package com.medopad.game.Snapshot.moveHorizon;

import com.medopad.game.Point;
import com.medopad.game.PointConstant;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveHorPieceUp extends MoveHorPiece {

    MoveHorPieceUp(Snapshot from, Direction direction, String val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        this.space1.y -= VER_OFFSET;
        this.space2.y -= VER_OFFSET;
    }

    public void movePiece(Point point, String val) {
        this.maps.set(point, val);
        this.maps.set(point.up(), PointConstant.SPACE);
        if (val.equals(PointConstant.HOR_PIECE_RIGHT)) {
            this.maps.set(point.left(), PointConstant.HOR_PIECE_LEFT);
            this.maps.set(point.offset(-1, -1), PointConstant.SPACE);
        } else if (val.equals(PointConstant.HOR_PIECE_LEFT)) {
            this.maps.set(point.right(), PointConstant.HOR_PIECE_RIGHT);
            this.maps.set(point.offset(1, -1), PointConstant.SPACE);
        }
    }
}
