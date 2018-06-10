package com.medopad.game.Snapshot.moveD;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveDPieceUp extends MoveDPiece {

    public MoveDPieceUp(Snapshot from, Direction direction, int val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        space1.y -= D_HEIGHT;
        space2.y -= D_HEIGHT;
    }

    public void movePiece(Point point, int val) {
        this.maps.set(point, val);
        this.maps.set(point.right(), Point.D_PIECE_RIGHT_BOT);
        this.maps.set(point.up(), Point.D_PIECE_LEFT_TOP);
        this.maps.set(point.offset(1, -1), Point.D_PIECE_RIGHT_TOP);
        this.maps.set(point.offsetY(-2), Point.SPACE);
        this.maps.set(point.offset(1, -2), Point.SPACE);
    }
}
