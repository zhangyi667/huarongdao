package com.medopad.game.Snapshot;

import com.medopad.Util.NotNullLinkedList;
import com.medopad.game.Maps;
import com.medopad.game.Point;

import java.util.LinkedList;
import java.util.List;


public class Snapshot {
    protected Maps maps;

    protected Point space1;

    protected Point space2;

    public Snapshot getParent() {
        return parent;
    }

    public Maps getMaps() {
        return this.maps;
    }

    public Point getSpace1() {
        return this.space1;
    }

    public void movePiece(Point point, int val) {
        this.maps.set(point, val);
        this.maps.set(point.left(), 0);
    }

    private void setParent(Snapshot parent) {
        this.parent = parent;
    }

    private Snapshot parent = null;
    private LinkedList<Snapshot> children = new LinkedList<>();


    public Snapshot(Snapshot from) {
        this.maps = new Maps(from.maps);
        this.space1 = new Point(from.space1);
        this.space2 = new Point(from.space2);
    }

    public Snapshot(int maps[], int rows, int cols) {
        this.maps = new Maps(maps, rows, cols);
        Point[] points = this.maps.space();
        space1 = points[0];
        space2 = points[1];
    }


    public List<Snapshot> listAllPossibleNextMove() {
        List<Snapshot> arr = new NotNullLinkedList<>();
        for (Direction d : Direction.values()) {
            arr.add(createSnapshot1(d));
            arr.add(createSnapshot2(space2, d));
        }
        return arr;
    }


    protected Snapshot createSnapshot1(Direction direction) {
        if (direction == Direction.LEFT && this.space1.x >= 1) {
            return getSnapshot(direction);
        } else if (direction == Direction.RIGHT && this.space1.x < maps.getCols() - 1) {
            return getSnapshot(direction);
        } else if (direction == Direction.UP && this.space1.y >= 1) {
            return getSnapshot(direction);
        } else if (direction == Direction.DOWN && this.space1.y < maps.getRows() - 1) {
            return getSnapshot(direction);
        }
        return null;
    }

    private Snapshot getSnapshot(Direction direction) {
        Snapshot snapshot;
        int val = maps.get(this.space1.getNeighbour(direction));
        snapshot = SnapshotFactory.getSnapshot(val, direction, this);
        if (null != snapshot)
            snapshot.movePiece(this.space1, val);
        return snapshot;
    }


    protected Snapshot createSnapshot2(Point point, Direction direction) {
        int val;
        Snapshot snapshot = null;

        if (direction == Direction.LEFT && this.space2.x >= 1) {
            val = maps.get(this.space2.left());
            if (val == Point.SINGLE_PIECE) {
                snapshot = new Snapshot(this);
                snapshot.space2.x -= 1;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.left(), 0);
            } else if (val == Point.HOR_PIECE_RIGHT) {
                snapshot = new Snapshot(this);
                snapshot.space2.x -= 2;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.left(), 2);
                snapshot.maps.set(this.space2.offsetX(-2), 0);
            }
        } else if (direction == Direction.RIGHT && this.space2.x < maps.cols - 1) {
            val = maps.get(this.space2.right());
            if (val == Point.SINGLE_PIECE) {
                snapshot = new Snapshot(this);
                snapshot.space2.x += 1;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.right(), 0);
            } else if (val == Point.HOR_PIECE_LEFT) {
                snapshot = new Snapshot(this);
                snapshot.space2.x += 2;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.right(), 3);
                snapshot.maps.set(this.space2.offsetX(+2), 0);
            }
        } else if (direction == Direction.UP && this.space2.y >= 1) {
            val = maps.get(this.space2.up());
            if (val == Point.SINGLE_PIECE) {
                snapshot = new Snapshot(this);
                snapshot.space2.y -= 1;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.up(), 0);
            } else if (val == Point.VERTICAL_PIECE_BOTTOM) {
                snapshot = new Snapshot(this);
                snapshot.space2.y -= 2;
                snapshot.maps.set(this.space2, 5);
                snapshot.maps.set(this.space2.up(), 4);
                snapshot.maps.set(this.space2.offsetY(-2), 0);
            }
        } else if (direction == Direction.DOWN && this.space2.y < maps.rows - 1) {
            val = maps.get(this.space2.down());
            if (val == Point.SINGLE_PIECE) {
                snapshot = new Snapshot(this);
                snapshot.space2.y += 1;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.down(), 0);
            } else if (val == Point.VERTICAL_PIECE_TOP) {
                snapshot = new Snapshot(this);
                snapshot.space2.y += 2;
                snapshot.maps.set(this.space2, 4);
                snapshot.maps.set(this.space2.down(), 5);
                snapshot.maps.set(this.space2.offsetY(+2), 0);
            }
        }

        return snapshot;
    }

    public void add(Snapshot child) {
        children.add(child);
        child.setParent(this);
    }

    public boolean isEnd(Point endPosition1, Point endPosition2) {
        int val1 = maps.get(endPosition1);
        int val2 = maps.get(endPosition2);
        return val1 >= 8 && val2 >= 8;
    }


    public void print() {
        maps.print();
    }

    public String getHashKey() {
        return maps.hashKeys();
    }
}
