package com.medopad.game.Snapshot.moveVertical;

import com.medopad.game.PointConstant;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveVerPieceDown extends MoveVerPiece {


    public MoveVerPieceDown(Snapshot from, Direction direction, String val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        assert PointConstant.Point.belongsToVerticalPieceTop(val);
        space1.y += VER_HEIGHT;
    }

    public void movePiece(PointConstant.Point point, String val) {
        this.maps.set(point, val);
        this.maps.set(point.getNeighbour(direction), PointConstant.Point.getBottomPieceFromTop(val));
        this.maps.set(point.offsetY(+2), PointConstant.Point.SPACE);
    }
}
