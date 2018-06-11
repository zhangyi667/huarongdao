package com.medopad.game.Snapshot.moveHorizon;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveHorPieceLeft extends MoveHorPiece {

    public MoveHorPieceLeft(Snapshot from, Direction direction, String val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        assert this.val.equals(Point.HOR_PIECE_RIGHT);
        this.space1.x -= 2;
    }

    public void movePiece(Point point, String val) {
        this.maps.set(point, val);
        this.maps.set(point.getNeighbour(direction), Point.HOR_PIECE_LEFT);
        this.maps.set(point.offsetX(-2), Point.SPACE);
    }
}
