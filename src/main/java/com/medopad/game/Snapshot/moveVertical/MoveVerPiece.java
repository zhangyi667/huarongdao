package com.medopad.game.Snapshot.moveVertical;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public abstract class MoveVerPiece extends Snapshot {

    Direction direction;

    int val;

    protected static final int VER_OFFSET = 1;

    public MoveVerPiece(Snapshot from, Direction direction, int val) {
        super(from);
        this.direction = direction;
        this.val = val;
        setSpaceButtons();
    }

    abstract void setSpaceButtons();


    public abstract void movePiece(Point point, int val);


}
