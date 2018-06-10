package com.medopad.game.Snapshot.moveVertical;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveVerPieceRight extends MoveVerPiece {

    public MoveVerPieceRight(Snapshot from, Direction direction, int val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        this.space1.x += VER_LENGTH;
        this.space2.x += VER_LENGTH;
    }

    public void movePiece(Point point, int val) {
        this.maps.set(point.right(), Point.SPACE);
        this.maps.set(point, val);

        if (val == Point.VERTICAL_PIECE_TOP) {
            this.maps.set(point.down(), Point.VERTICAL_PIECE_BOTTOM);
            this.maps.set(point.offset(+1, +1), 0);
        } else if (val == Point.VERTICAL_PIECE_BOTTOM) {
            this.maps.set(point.up(), Point.VERTICAL_PIECE_TOP);
            this.maps.set(point.offset(+1, -1), 0);
        }
    }
}
