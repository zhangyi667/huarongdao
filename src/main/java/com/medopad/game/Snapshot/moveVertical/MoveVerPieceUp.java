package com.medopad.game.Snapshot.moveVertical;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveVerPieceUp extends MoveVerPiece {

    public MoveVerPieceUp(Snapshot from, Direction direction, String val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        assert Point.belongsToVerticalPieceBottom(val);
        space1.y -= VER_HEIGHT;
    }

    public void movePiece(Point point, String val) {
        maps.set(point, val);
        maps.set(point.getNeighbour(direction), Point.getTopPieceFromBottom(val));
        maps.set(point.offsetY(-2), Point.SPACE);
    }
}
