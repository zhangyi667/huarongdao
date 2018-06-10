package com.medopad.game.Snapshot.moveVertical;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveVerPieceUp extends MoveVerPiece {

    public MoveVerPieceUp(Snapshot from, Direction direction, int val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        assert val == Point.VERTICAL_PIECE_BOTTOM;
        space1.y -= 2;
    }

    public void movePiece(Point point, int val) {
        maps.set(this.space1, val);
        maps.set(this.space1.getNeighbour(direction), Point.VERTICAL_PIECE_TOP);
        maps.set(this.space1.offsetY(-2), Point.SPACE);
    }
}
