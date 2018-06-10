package com.medopad.game.Snapshot.moveHorizon;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveHorPieceUp extends MoveHorPiece {

    public MoveHorPieceUp(Snapshot from, Direction direction, int val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        this.space1.y -= VER_OFFSET;
        this.space2.y -= VER_OFFSET;
    }

    public void movePiece(Point point, int val) {
        this.maps.set(point, val);
        this.maps.set(point.up(), Point.SPACE);
        if (val == Point.HOR_PIECE_RIGHT) {
            this.maps.set(point.left(), Point.HOR_PIECE_LEFT);
            this.maps.set(point.offset(-1, -1), Point.SPACE);
        } else if (val == Point.HOR_PIECE_LEFT) {
            this.maps.set(point.right(), Point.HOR_PIECE_RIGHT);
            this.maps.set(point.offset(1, -1), Point.SPACE);
        }
    }
}
