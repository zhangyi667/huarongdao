package com.medopad.game.Snapshot.moveVertical;

import com.medopad.game.PointBackup;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveVerPieceRight extends MoveVerPiece {

    public MoveVerPieceRight(Snapshot from, Direction direction, String val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        this.space1.x += VER_LENGTH;
        this.space2.x += VER_LENGTH;
    }

    public void movePiece(PointBackup point, String val) {
        this.maps.set(point.right(), PointBackup.SPACE);
        this.maps.set(point, val);

        if (PointBackup.belongsToVerticalPieceTop(val)) {
            this.maps.set(point.down(), PointBackup.getBottomPieceFromTop(val));
            this.maps.set(point.offset(+1, +1), PointBackup.SPACE);
        } else if (PointBackup.belongsToVerticalPieceBottom(val)) {
            this.maps.set(point.up(), PointBackup.getTopPieceFromBottom(val));
            this.maps.set(point.offset(+1, -1), PointBackup.SPACE);
        }
    }
}
