package com.medopad.game.Snapshot.moveD;

import com.medopad.game.PointBackup;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public abstract class MoveDPiece extends Snapshot {

    Direction direction;

    String val;

    static final int D_LENGTH = 2;
    static final int D_HEIGHT = 2;

    public MoveDPiece(Snapshot from, Direction direction, String val) {
        super(from);
        this.direction = direction;
        this.val = val;
        setSpaceButtons();
    }

    abstract void setSpaceButtons();


    public abstract void movePiece(PointBackup point, String val);


}
