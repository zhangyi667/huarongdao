package com.medopad.game.Snapshot;

import com.medopad.Util.NotNullLinkedList;
import com.medopad.game.MapsBackup;
import com.medopad.game.PointBackup;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.LinkedList;
import java.util.List;


public class Snapshot {
    protected MapsBackup maps;
    protected PointBackup space1;

    protected PointBackup space2;

    public Snapshot getParent() {
        return parent;
    }

    public MapsBackup getMaps() {
        return this.maps;
    }

    public PointBackup getSpace1() {
        return this.space1;
    }

    public void movePiece(PointBackup point, String val) {
//        getMaps().set(point, val);
//        getMaps().set(point.left(), PointBackup.SPACE);
    }

    private void setParent(Snapshot parent) {
        this.parent = parent;
    }

    private Snapshot parent = null;
    private LinkedList<Snapshot> children = new LinkedList<>();


    public Snapshot(Snapshot from) {
        this.maps = new MapsBackup(from.maps);
        this.space1 = new PointBackup(from.space1);
        this.space2 = new PointBackup(from.space2);
        if (!this.maps.get(this.space1).equals(PointBackup.SPACE))
           throw new InvalidStateException("Why is this not space");
    }

    public Snapshot(String[][] maps) {
        this.maps = new MapsBackup(maps);
        PointBackup[] points = getMaps().space();
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


    protected Snapshot createSnapshot2(PointBackup point, Direction direction) {
        String val;
        Snapshot snapshot = null;

        if (direction == Direction.LEFT && this.space2.x >= 2) {
            val = maps.get(this.space2.left());
            if (PointBackup.isSinglePiece(val)) {
                snapshot = new Snapshot(this);
                snapshot.space2.x -= 1;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.left(), PointBackup.SPACE);
            } else if (val.equals(PointBackup.HOR_PIECE_RIGHT)) {
                snapshot = new Snapshot(this);
                snapshot.space2.x -= 2;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.left(), PointBackup.HOR_PIECE_LEFT);
                snapshot.maps.set(this.space2.offsetX(-2), PointBackup.SPACE);
            }
        } else if (direction == Direction.RIGHT && this.space2.x < maps.getCols() - 2) {
            val = maps.get(this.space2.right());
            if (PointBackup.isSinglePiece(val)) {
                snapshot = new Snapshot(this);
                snapshot.space2.x += 1;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.right(), PointBackup.SPACE);
            } else if (val.equals(PointBackup.HOR_PIECE_LEFT)) {
                snapshot = new Snapshot(this);
                snapshot.space2.x += 2;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.right(), PointBackup.HOR_PIECE_RIGHT);
                snapshot.maps.set(this.space2.offsetX(+2), PointBackup.SPACE);
            }
        } else if (direction == Direction.UP && this.space2.y >= 2) {
            val = maps.get(this.space2.up());
            if (PointBackup.isSinglePiece(val)) {
                snapshot = new Snapshot(this);
                snapshot.space2.y -= 1;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.up(), PointBackup.SPACE);
            } else if (PointBackup.belongsToVerticalPieceBottom(val)) {
                snapshot = new Snapshot(this);
                snapshot.space2.y -= 2;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.up(), PointBackup.getTopPieceFromBottom(val));
                snapshot.maps.set(this.space2.offsetY(-2), PointBackup.SPACE);
            }
        } else if (direction == Direction.DOWN && this.space2.y < maps.getRows() - 2) {
            val = maps.get(this.space2.down());
            if (PointBackup.isSinglePiece(val)) {
                snapshot = new Snapshot(this);
                snapshot.space2.y += 1;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.down(), PointBackup.SPACE);
            } else if (PointBackup.belongsToVerticalPieceTop(val)) {
                snapshot = new Snapshot(this);
                snapshot.space2.y += 2;
                snapshot.maps.set(this.space2, val);
                snapshot.maps.set(this.space2.down(), PointBackup.getBottomPieceFromTop(val));
                snapshot.maps.set(this.space2.offsetY(+2), PointBackup.SPACE);
            }
        }

        return snapshot;
    }

    public void add(Snapshot child) {
        children.add(child);
        child.setParent(this);
    }

    public boolean isEnd(PointBackup endPositionLeft, PointBackup endPositionRight) {
        String left = maps.get(endPositionLeft);
        String right = maps.get(endPositionRight);
        return (PointBackup.D_PIECE_LEFT_BOT.equals(left) || PointBackup.D_PIECE_RIGHT_BOT.equals(left)) &&
                (PointBackup.D_PIECE_LEFT_BOT.equals(right) || PointBackup.D_PIECE_RIGHT_BOT.equals(right));
    }


    public void print() {
        maps.print();
    }

    public String getHashKey() {
        return maps.hashKeys();
    }
}
