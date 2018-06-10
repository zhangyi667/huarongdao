package com.medopad.game.Snapshot.moveHorizon;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveHorPieceRight extends MoveHorPiece {

    public MoveHorPieceRight(Snapshot from, Direction direction, int val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        assert this.val == Point.HOR_PIECE_LEFT;
        space1.x += 2;
    }

    public void movePiece(Point point, int val) {
        assert this.val == Point.HOR_PIECE_LEFT;
        this.maps.set(point, val);
        this.maps.set(point.getNeighbour(direction), Point.HOR_PIECE_RIGHT);
        this.maps.set(point.offsetX(2), Point.SPACE);
    }
}
