package com.medopad.game.Snapshot.moveSingle;

import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveSingleUp extends MoveSingle {
    public MoveSingleUp(Snapshot from, Direction direction) {
        super(from, direction);
    }

    @Override
    void setSpaceButtons(Direction direction) {
        this.space1.y -= OFFSET;
    }

}
