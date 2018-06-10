package com.medopad.game.Snapshot.moveD;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public abstract class MoveDPiece extends Snapshot {

    Direction direction;

    int val;

    protected static final int D_LENGTH = 2;
    protected static final int D_HEIGHT = 2;

    public MoveDPiece(Snapshot from, Direction direction, int val) {
        super(from);
        this.direction = direction;
        this.val = val;
        setSpaceButtons();
    }

    abstract void setSpaceButtons();


    public abstract void movePiece(Point point, int val);


}
