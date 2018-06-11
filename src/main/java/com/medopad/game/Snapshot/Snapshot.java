package com.medopad.game.Snapshot;

import com.medopad.Util.NotNullLinkedList;
import com.medopad.game.Maps;
import com.medopad.game.Point;
import com.medopad.game.PointConstant;

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

    public void movePiece(Point point, String val) {
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

    public Snapshot(String[][] maps) {
        this.maps = new Maps(maps);
        Point[] points = getMaps().space();
        space1 = points[0];
        space2 = points[1];
    }

    public List<Snapshot> listAllPossibleNextMove() {
        List<Snapshot> arr = new NotNullLinkedList<>();
        for (Direction d : Direction.values()) {
            arr.add(createSnapshot1(d));
            arr.add(createSnapshot2(d));
        }
        return arr;
    }

    protected Snapshot createSnapshot1(Direction direction) {
        if (direction == Direction.LEFT && this.space1.x >= 2) { // because of border 'x'
            return getSnapshot(direction);
        } else if (direction == Direction.RIGHT && this.space1.x < maps.getCols() - 2) {
            return getSnapshot(direction);
        } else if (direction == Direction.UP && this.space1.y >= 2) {
            return getSnapshot(direction);
        } else if (direction == Direction.DOWN && this.space1.y < maps.getRows() - 2) {
            return getSnapshot(direction);
        }
        return null;
    }

    private Snapshot getSnapshot(Direction direction) {
        Snapshot snapshot;
        String val = maps.get(this.space1.getNeighbour(direction));
        snapshot = SnapshotFactory.getSnapshot(val, direction, this);
        if (null != snapshot)
            snapshot.movePiece(this.space1, val);
        return snapshot;
    }


    protected Snapshot createSnapshot2(Direction direction) {
        String val = maps.get(this.space2.getNeighbour(direction));
        Snapshot snapshot = null;

        if (direction == Direction.LEFT && this.space2.x >= 2) {
            if (Point.isSinglePiece(val)) {
                snapshot = new Snapshot(this);
                snapshot.space2.x -= 1;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.getNeighbour(direction), PointConstant.SPACE);
            } else if (val.equals(PointConstant.HOR_PIECE_RIGHT)) {
                snapshot = new Snapshot(this);
                snapshot.space2.x -= 2;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.getNeighbour(direction), PointConstant.HOR_PIECE_LEFT);
                snapshot.maps.set(this.space2.offsetX(-2), PointConstant.SPACE);
            }
        } else if (direction == Direction.RIGHT && this.space2.x < maps.getCols() - 2) {
            if (Point.isSinglePiece(val)) {
                snapshot = new Snapshot(this);
                snapshot.space2.x += 1;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.getNeighbour(direction), PointConstant.SPACE);
            } else if (val.equals(PointConstant.HOR_PIECE_LEFT)) {
                snapshot = new Snapshot(this);
                snapshot.space2.x += 2;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.getNeighbour(direction), PointConstant.HOR_PIECE_RIGHT);
                snapshot.maps.set(this.space2.offsetX(+2), PointConstant.SPACE);
            }
        } else if (direction == Direction.UP && this.space2.y >= 2) {
            if (Point.isSinglePiece(val)) {
                snapshot = new Snapshot(this);
                snapshot.space2.y -= 1;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.getNeighbour(direction), PointConstant.SPACE);
            } else if (Point.belongsToVerticalPieceBottom(val)) {
                snapshot = new Snapshot(this);
                snapshot.space2.y -= 2;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.getNeighbour(direction), Point.getTopPieceFromBottom(val));
                snapshot.maps.set(this.space2.offsetY(-2), PointConstant.SPACE);
            }
        } else if (direction == Direction.DOWN && this.space2.y < maps.getRows() - 2) {
            if (Point.isSinglePiece(val)) {
                snapshot = new Snapshot(this);
                snapshot.space2.y += 1;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.getNeighbour(direction), PointConstant.SPACE);
            } else if (Point.belongsToVerticalPieceTop(val)) {
                snapshot = new Snapshot(this);
                snapshot.space2.y += 2;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.getNeighbour(direction), Point.getBottomPieceFromTop(val));
                snapshot.maps.set(this.space2.offsetY(+2), PointConstant.SPACE);
            }
        }

        return snapshot;
    }

    public void add(Snapshot child) {
        children.add(child);
        child.setParent(this);
    }

    public boolean isEnd(Point endPositionLeft, Point endPositionRight) {
        String left = maps.get(endPositionLeft);
        String right = maps.get(endPositionRight);
        return (PointConstant.D_PIECE_LEFT_BOT.equals(left) || PointConstant.D_PIECE_RIGHT_BOT.equals(left)) &&
                (PointConstant.D_PIECE_LEFT_BOT.equals(right) || PointConstant.D_PIECE_RIGHT_BOT.equals(right));
    }


    public void print() {
        maps.print();
    }

    public String getHashKey() {
        return maps.hashKeys();
    }
}
