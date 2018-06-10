package com.medopad.game.Snapshot.moveHorizon;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public abstract class MoveHorPiece extends Snapshot {

    Direction direction;

    int val;

    protected static final int VER_OFFSET = 1;

    public MoveHorPiece(Snapshot from, Direction direction, int val) {
        super(from);
        this.direction = direction;
        this.val = val;
        setSpaceButtons();
    }

    abstract void setSpaceButtons();

    public abstract void movePiece(Point point, int val);

    public void movePieceVertically(Point point, int val) {
        if (val == Point.HOR_PIECE_RIGHT) {
            this.maps.set(point.left(), Point.HOR_PIECE_LEFT);
            this.maps.set(point.offset(-1, +1), Point.SPACE);
        } else if (val == Point.HOR_PIECE_LEFT) {
            this.maps.set(point.right(), Point.HOR_PIECE_RIGHT);
            this.maps.set(point.offset(1, 1), Point.SPACE);
        }

    }
}
