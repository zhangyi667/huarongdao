package com.medopad.game.Snapshot.moveD;

import com.medopad.game.PointBackup;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveDPieceLeft extends MoveDPiece {

    public MoveDPieceLeft(Snapshot from, Direction direction, String val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        this.space1.x -= D_LENGTH;
        this.space2.x -= D_LENGTH;
    }

    public void movePiece(PointBackup point, String val) {
        this.maps.set(point, val);
        this.maps.set(point.down(), PointBackup.D_PIECE_RIGHT_BOT);
        this.maps.set(point.left(), PointBackup.D_PIECE_LEFT_TOP);
        this.maps.set(point.offset(-1, 1), PointBackup.D_PIECE_LEFT_BOT);
        this.maps.set(point.offsetX(-2), PointBackup.SPACE);
        this.maps.set(point.offset(-2, 1), PointBackup.SPACE);
    }
}
