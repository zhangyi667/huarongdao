package com.medopad.game.Snapshot.moveHorizon;

import com.medopad.game.PointConstant;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveHorPieceDown extends MoveHorPiece {


    public MoveHorPieceDown(Snapshot from, Direction direction, String val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        this.space1.y += VER_OFFSET;
        this.space2.y += VER_OFFSET;
    }

    public void movePiece(PointConstant.Point point, String val) {
        this.maps.set(point, val);
        this.maps.set(point.down(), PointConstant.Point.SPACE);

        if (val.equals(PointConstant.Point.HOR_PIECE_RIGHT)) {
            this.maps.set(point.left(), PointConstant.Point.HOR_PIECE_LEFT);
            this.maps.set(point.offset(-1, +1), PointConstant.Point.SPACE);
        } else if (val.equals(PointConstant.Point.HOR_PIECE_LEFT)) {
            this.maps.set(point.right(), PointConstant.Point.HOR_PIECE_RIGHT);
            this.maps.set(point.offset(1, 1), PointConstant.Point.SPACE);
        }
    }

}
