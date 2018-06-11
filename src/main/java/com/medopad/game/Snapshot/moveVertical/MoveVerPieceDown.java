package com.medopad.game.Snapshot.moveVertical;

import com.medopad.game.PointBackup;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveVerPieceDown extends MoveVerPiece {


    public MoveVerPieceDown(Snapshot from, Direction direction, String val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        assert PointBackup.belongsToVerticalPieceTop(val);
        space1.y += VER_HEIGHT;
    }

    public void movePiece(PointBackup point, String val) {
        this.maps.set(point, val);
        this.maps.set(point.getNeighbour(direction), PointBackup.getBottomPieceFromTop(val));
        this.maps.set(point.offsetY(+2), PointBackup.SPACE);
    }
}
