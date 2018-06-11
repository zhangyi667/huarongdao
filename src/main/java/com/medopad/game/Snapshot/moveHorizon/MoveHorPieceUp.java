package com.medopad.game.Snapshot.moveHorizon;

import com.medopad.game.PointBackup;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveHorPieceUp extends MoveHorPiece {

    MoveHorPieceUp(Snapshot from, Direction direction, String val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        this.space1.y -= VER_OFFSET;
        this.space2.y -= VER_OFFSET;
    }

    public void movePiece(PointBackup point, String val) {
        this.maps.set(point, val);
        this.maps.set(point.up(), PointBackup.SPACE);
        if (val.equals(PointBackup.HOR_PIECE_RIGHT)) {
            this.maps.set(point.left(), PointBackup.HOR_PIECE_LEFT);
            this.maps.set(point.offset(-1, -1), PointBackup.SPACE);
        } else if (val.equals(PointBackup.HOR_PIECE_LEFT)) {
            this.maps.set(point.right(), PointBackup.HOR_PIECE_RIGHT);
            this.maps.set(point.offset(1, -1), PointBackup.SPACE);
        }
    }
}
