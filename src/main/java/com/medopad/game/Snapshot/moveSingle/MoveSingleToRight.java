package com.medopad.game.Snapshot.moveSingle;

import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveSingleToRight extends MoveSingle {
    public MoveSingleToRight(Snapshot from, Direction direction) {
        super(from, direction);
    }

    @Override
    void setSpaceButtons(Direction direction) {
        this.space1.x += OFFSET;
    }
}
