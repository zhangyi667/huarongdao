package com.medopad.game.Snapshot.moveD;

import com.medopad.game.Point;
import com.medopad.game.PointConstant;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveDPieceRight extends MoveDPiece {

    MoveDPieceRight(Snapshot from, Direction direction, String val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        this.space1.x += D_LENGTH;
        this.space2.x += D_LENGTH;
    }

    public void movePiece(Point point, String val) {
        this.maps.set(point, val);
        this.maps.set(point.down(), PointConstant.D_PIECE_LEFT_BOT);
        this.maps.set(point.right(), PointConstant.D_PIECE_RIGHT_TOP);
        this.maps.set(point.offset(+1, +1), PointConstant.D_PIECE_RIGHT_BOT);
        this.maps.set(point.offsetX(+2), PointConstant.SPACE);
        this.maps.set(point.offset(+2, +1), PointConstant.SPACE);
    }
}
