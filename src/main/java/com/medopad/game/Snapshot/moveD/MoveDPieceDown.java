package com.medopad.game.Snapshot.moveD;

import com.medopad.game.Point;
import com.medopad.game.PointConstant;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveDPieceDown extends MoveDPiece {

    public MoveDPieceDown(Snapshot from, Direction direction, String val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        space1.y += D_HEIGHT;
        space2.y += D_HEIGHT;
    }

    public void movePiece(Point point, String val) {
        this.maps.set(point, val);
        this.maps.set(point.right(), PointConstant.D_PIECE_RIGHT_TOP);
        this.maps.set(point.down(), PointConstant.D_PIECE_LEFT_BOT);
        this.maps.set(point.offset(+1, +1), PointConstant.D_PIECE_RIGHT_BOT);
        this.maps.set(point.offsetY(+2), PointConstant.SPACE);
        this.maps.set(point.offset(+1, +2), PointConstant.SPACE);
    }
}
