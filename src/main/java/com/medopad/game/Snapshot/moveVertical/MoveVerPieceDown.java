package com.medopad.game.Snapshot.moveVertical;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveVerPieceDown extends MoveVerPiece {


    public MoveVerPieceDown(Snapshot from, Direction direction, int val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        assert val == Point.VERTICAL_PIECE_TOP;
        space1.y += VER_HEIGHT;
    }

    public void movePiece(Point point, int val) {
        this.maps.set(point, val);
        this.maps.set(point.getNeighbour(direction), Point.VERTICAL_PIECE_BOTTOM);
        this.maps.set(point.offsetY(+2), Point.SPACE);
    }
}
