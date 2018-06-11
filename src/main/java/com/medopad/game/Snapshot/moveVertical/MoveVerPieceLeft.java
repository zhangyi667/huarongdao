package com.medopad.game.Snapshot.moveVertical;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveVerPieceLeft extends MoveVerPiece {

    public MoveVerPieceLeft(Snapshot from, Direction direction, String val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        this.space1.x -= VER_LENGTH;
        this.space2.x -= VER_LENGTH;
    }

    public void movePiece(Point point, String val) {
        this.maps.set(point, val);
        this.maps.set(point.left(), Point.SPACE);

        if (Point.belongsToVerticalPieceTop(val)) {
            this.maps.set(point.down(), Point.getBottomPieceFromTop(val));
            this.maps.set(point.offset(-1, 1), Point.SPACE);
        } else if (Point.belongsToVerticalPieceBottom(val)) {
            this.maps.set(point.up(), Point.getTopPieceFromBottom(val));
            this.maps.set(point.offset(-1, -1), Point.SPACE);
        }
    }
}
