package com.medopad.game.Snapshot.moveVertical;

import com.medopad.game.PointBackup;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public abstract class MoveVerPiece extends Snapshot {

    Direction direction;

    String val;

    static final int VER_HEIGHT = 2;
    static final int VER_LENGTH = 1;

    MoveVerPiece(Snapshot from, Direction direction, String val) {
        super(from);
        this.direction = direction;
        this.val = val;
        setSpaceButtons();
    }

    abstract void setSpaceButtons();


    public abstract void movePiece(PointBackup point, String val);


}
