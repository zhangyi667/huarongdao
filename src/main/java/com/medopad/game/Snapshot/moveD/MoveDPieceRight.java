package com.medopad.game.Snapshot.moveD;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveDPieceRight extends MoveDPiece {

    public MoveDPieceRight(Snapshot from, Direction direction, int val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        this.space1.x += D_LENGTH;
        this.space2.x += D_LENGTH;
    }

    public void movePiece(Point point, int val) {
        this.maps.set(point, val);
        this.maps.set(point.down(), Point.D_PIECE_LEFT_BOT);
        this.maps.set(point.right(), Point.D_PIECE_RIGHT_TOP);
        this.maps.set(point.offset(+1, +1), Point.D_PIECE_RIGHT_BOT);
        this.maps.set(point.offsetX(+2), Point.SPACE);
        this.maps.set(point.offset(+2, +1), Point.SPACE);
    }
}
