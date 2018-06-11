package com.medopad.game.Snapshot.moveHorizon;

import com.medopad.game.PointConstant;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public abstract class MoveHorPiece extends Snapshot {

    Direction direction;

    String val;

    protected static final int VER_OFFSET = 1;

    public MoveHorPiece(Snapshot from, Direction direction, String val) {
        super(from);
        this.direction = direction;
        this.val = val;
        setSpaceButtons();
    }

    abstract void setSpaceButtons();

    public abstract void movePiece(PointConstant.Point point, String val);

    public void movePieceVertically(PointConstant.Point point, String val) {
        if (val.equals(PointConstant.Point.HOR_PIECE_RIGHT)) {
            this.maps.set(point.left(), PointConstant.Point.HOR_PIECE_LEFT);
            this.maps.set(point.offset(-1, +1), PointConstant.Point.SPACE);
        } else if (val.equals(PointConstant.Point.HOR_PIECE_LEFT)) {
            this.maps.set(point.right(), PointConstant.Point.HOR_PIECE_RIGHT);
            this.maps.set(point.offset(1, 1), PointConstant.Point.SPACE);
        }

    }
}
