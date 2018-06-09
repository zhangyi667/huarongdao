package com.medopad.game;

import com.medopad.Util.NotNullLinkedList;

import java.util.*;


public class Snapshot {
    private Maps maps;

    private Point empty1;

    private Point empty2;

    public Snapshot getParent() {
        return parent;
    }

    private void setParent(Snapshot parent) {
        this.parent = parent;
    }

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    private Snapshot parent = null;
    private LinkedList<Snapshot> children = new LinkedList<>();


    public Snapshot(Snapshot from) {
        this.maps = new Maps(from.maps);
        this.empty1 = new Point(from.empty1);
        this.empty2 = new Point(from.empty2);
    }

    public Snapshot(int maps[], int rows, int cols) {
        this.maps = new Maps(maps, rows, cols);
        Point[] points = this.maps.space();
        empty1 = points[0];
        empty2 = points[1];
    }


    public LinkedList<Snapshot> listAllPossibleNextMove() {
        LinkedList<Snapshot> arr = new NotNullLinkedList<>();
        for (Direction d : Direction.values()) {
            arr.add(createSnapshot1(empty1, d));
            arr.add(createSnapshot2(empty2, d));
        }
        return arr;
    }


    protected Snapshot createSnapshot1(Point point, Direction direction) {
        int val;
        Snapshot snapshot = null;

        if (direction == Direction.LEFT && point.x >= 1) {
            val = maps.get(point.left());
            if (val == 1) {
                snapshot = new Snapshot(this);
                snapshot.empty1.x -= 1;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.left(), 0);
            } else if (val == 3) {
                snapshot = new Snapshot(this);
                snapshot.empty1.x -= 2;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.left(), 2);
                snapshot.maps.set(point.offsetX(-2), 0);
            } else if (val == 4 && maps.get(point.down()) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.x -= 1;
                snapshot.empty2.x -= 1;
                snapshot.maps.set(point, 4);
                snapshot.maps.set(point.down(), 5);
                snapshot.maps.set(point.left(), 0);
                snapshot.maps.set(point.offset(-1, 1), 0);
            } else if (val == 5 && maps.get(point.up()) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.x -= 1;
                snapshot.empty2.x -= 1;
                snapshot.maps.set(point, 5);
                snapshot.maps.set(point.up(), 4);
                snapshot.maps.set(point.left(), 0);
                snapshot.maps.set(point.offset(-1, -1), 0);
            } else if (val == 7 && maps.get(point.down()) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.x -= 2;
                snapshot.empty2.x -= 2;
                snapshot.maps.set(point, 7);
                snapshot.maps.set(point.down(), 9);
                snapshot.maps.set(point.left(), 6);
                snapshot.maps.set(point.offset(-1, 1), 8);
                snapshot.maps.set(point.offsetX(-2), 0);
                snapshot.maps.set(point.offset(-2, 1), 0);
            } else if (val == 9 && maps.get(point.up()) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.x -= 2;
                snapshot.empty2.x -= 2;
                snapshot.maps.set(point, 9);
                snapshot.maps.set(point.up(), 7);
                snapshot.maps.set(point.left(), 8);
                snapshot.maps.set(point.offset(-1, -1), 6);
                snapshot.maps.set(point.offsetX(-2), 0);
                snapshot.maps.set(point.offset(-2, -1), 0);
            }
        } else if (direction == Direction.RIGHT && point.x < maps.cols - 1) {
            val = maps.get(point.right());
            if (val == 1) {
                snapshot = new Snapshot(this);
                snapshot.empty1.x += 1;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.right(), 0);
            } else if (val == 2) {
                snapshot = new Snapshot(this);
                snapshot.empty1.x += 2;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.right(), 3);
                snapshot.maps.set(point.offsetX(2), 0);
            } else if (val == 4 && maps.get(point.down()) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.x += 1;
                snapshot.empty2.x += 1;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetY(+1), 5);
                snapshot.maps.set(point.offsetX(+1), 0);
                snapshot.maps.set(point.offset(+1, +1), 0);
            } else if (val == 5 && maps.get(point.offsetY(-1)) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.x += 1;
                snapshot.empty2.x += 1;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetY(-1), 4);
                snapshot.maps.set(point.offsetX(+1), 0);
                snapshot.maps.set(point.offset(+1, -1), 0);
            } else if (val == 6 && maps.get(point.offsetY(+1)) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.x += 2;
                snapshot.empty2.x += 2;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetY(+1), 8);
                snapshot.maps.set(point.offsetX(+1), 7);
                snapshot.maps.set(point.offset(+1, +1), 9);
                snapshot.maps.set(point.offsetX(+2), 0);
                snapshot.maps.set(point.offset(+2, +1), 0);
            } else if (val == 8 && maps.get(point.offsetY(-1)) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.x += 2;
                snapshot.empty2.x += 2;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetY(-1), 6);
                snapshot.maps.set(point.offsetX(+1), 9);
                snapshot.maps.set(point.offset(+1, -1), 7);
                snapshot.maps.set(point.offsetX(+2), 0);
                snapshot.maps.set(point.offset(+2, -1), 0);
            }
        } else if (direction == Direction.UP && point.y >= 1) {
            val = maps.get(point.offsetY(-1));
            if (val == 1) {
                snapshot = new Snapshot(this);
                snapshot.empty1.y -= 1;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetY(-1), 0);
            } else if (val == 2 && maps.get(point.offsetX(+1)) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.y -= 1;
                snapshot.empty2.y -= 1;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetX(1), 3);
                snapshot.maps.set(point.offsetY(-1), 0);
                snapshot.maps.set(point.offset(1, -1), 0);
            } else if (val == 3 && maps.get(point.offsetX(-1)) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.y -= 1;
                snapshot.empty2.y -= 1;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetX(-1), 2);
                snapshot.maps.set(point.offsetY(-1), 0);
                snapshot.maps.set(point.offset(-1, -1), 0);
            } else if (val == 5) {
                snapshot = new Snapshot(this);
                snapshot.empty1.y -= 2;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetY(-1), 4);
                snapshot.maps.set(point.offsetY(-2), 0);
            } else if (val == 8 && maps.get(point.offsetX(+1)) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.y -= 2;
                snapshot.empty2.y -= 2;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetX(1), 9);
                snapshot.maps.set(point.offsetY(-1), 6);
                snapshot.maps.set(point.offset(1, -1), 7);
                snapshot.maps.set(point.offsetY(-2), 0);
                snapshot.maps.set(point.offset(1, -2), 0);
            } else if (val == 9 && maps.get(point.offsetX(-1)) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.y -= 2;
                snapshot.empty2.y -= 2;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetX(-1), 8);
                snapshot.maps.set(point.offsetY(-1), 7);
                snapshot.maps.set(point.offset(-1, -1), 6);
                snapshot.maps.set(point.offsetY(-2), 0);
                snapshot.maps.set(point.offset(-1, -2), 0);
            }
        } else if (direction == Direction.DOWN && point.y < maps.rows - 1) {
            val = maps.get(point.offsetY(+1));
            if (val == 1) {
                snapshot = new Snapshot(this);
                snapshot.empty1.y += 1;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetY(+1), 0);
            } else if (val == 2 && maps.get(point.offsetX(+1)) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.y += 1;
                snapshot.empty2.y += 1;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetX(1), 3);
                snapshot.maps.set(point.offsetY(+1), 0);
                snapshot.maps.set(point.offset(+1, +1), 0);
            } else if (val == 3 && maps.get(point.offsetX(-1)) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.y += 1;
                snapshot.empty2.y += 1;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetX(-1), 2);
                snapshot.maps.set(point.offsetY(+1), 0);
                snapshot.maps.set(point.offset(-1, +1), 0);
            } else if (val == 4) {
                snapshot = new Snapshot(this);
                snapshot.empty1.y += 2;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetY(+1), 5);
                snapshot.maps.set(point.offsetY(+2), 0);
            } else if (val == 6 && maps.get(point.offsetX(+1)) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.y += 2;
                snapshot.empty2.y += 2;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetX(1), 7);
                snapshot.maps.set(point.offsetY(+1), 8);
                snapshot.maps.set(point.offset(+1, +1), 9);
                snapshot.maps.set(point.offsetY(+2), 0);
                snapshot.maps.set(point.offset(+1, +2), 0);
            } else if (val == 7 && maps.get(point.offsetX(-1)) == 0) {
                snapshot = new Snapshot(this);
                snapshot.empty1.y += 2;
                snapshot.empty2.y += 2;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetX(-1), 6);
                snapshot.maps.set(point.offsetY(+1), 9);
                snapshot.maps.set(point.offset(-1, +1), 8);
                snapshot.maps.set(point.offsetY(+2), 0);
                snapshot.maps.set(point.offset(-1, +2), 0);
            }
        }

        return snapshot;
    }

    protected Snapshot createSnapshot2(Point point, Direction direction) {
        int val;
        Snapshot snapshot = null;

        if (direction == Direction.LEFT && point.x >= 1) {
            val = maps.get(point.offsetX(-1));
            if (val == 1) {
                snapshot = new Snapshot(this);
                snapshot.empty2.x -= 1;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetX(-1), 0);
            } else if (val == 3) {
                snapshot = new Snapshot(this);
                snapshot.empty2.x -= 2;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetX(-1), 2);
                snapshot.maps.set(point.offsetX(-2), 0);
            }
        } else if (direction == Direction.RIGHT && point.x < maps.cols - 1) {
            val = maps.get(point.offsetX(+1));
            if (val == 1) {
                snapshot = new Snapshot(this);
                snapshot.empty2.x += 1;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetX(+1), 0);
            } else if (val == 2) {
                snapshot = new Snapshot(this);
                snapshot.empty2.x += 2;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetX(+1), 3);
                snapshot.maps.set(point.offsetX(+2), 0);
            }
        } else if (direction == Direction.UP && point.y >= 1) {
            val = maps.get(point.offsetY(-1));
            if (val == 1) {
                snapshot = new Snapshot(this);
                snapshot.empty2.y -= 1;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetY(-1), 0);
            } else if (val == 5) {
                snapshot = new Snapshot(this);
                snapshot.empty2.y -= 2;
                snapshot.maps.set(point, 5);
                snapshot.maps.set(point.offsetY(-1), 4);
                snapshot.maps.set(point.offsetY(-2), 0);
            }
        } else if (direction == Direction.DOWN && point.y < maps.rows - 1) {
            val = maps.get(point.offsetY(+1));
            if (val == 1) {
                snapshot = new Snapshot(this);
                snapshot.empty2.y += 1;
                snapshot.maps.set(point, val);
                snapshot.maps.set(point.offsetY(+1), 0);
            } else if (val == 4) {
                snapshot = new Snapshot(this);
                snapshot.empty2.y += 2;
                snapshot.maps.set(point, 4);
                snapshot.maps.set(point.offsetY(+1), 5);
                snapshot.maps.set(point.offsetY(+2), 0);
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
        return val1 >= 6 && val2 >= 6;
    }


    public void print() {
        maps.print();
    }

    public String getHashKey() {
        return maps.hashKeys();
    }
}
