package com.medopad.game.Snapshot.moveVertical;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveVerPieceLeft extends MoveVerPiece {

    public MoveVerPieceLeft(Snapshot from, Direction direction, int val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        this.space1.x -= 1;
        this.space2.x -= 1;
    }

    public void movePiece(Point point, int val) {
        this.maps.set(point, val);
        this.maps.set(point.left(), Point.SPACE);

        if (val == Point.VERTICAL_PIECE_TOP) {
            this.maps.set(point.down(), Point.VERTICAL_PIECE_BOTTOM);
            this.maps.set(point.offset(-1, 1), 0);
        } else if (val == Point.VERTICAL_PIECE_BOTTOM) {
            this.maps.set(point.up(), Point.VERTICAL_PIECE_TOP);
            this.maps.set(point.offset(-1, -1), 0);
        }
    }
}
