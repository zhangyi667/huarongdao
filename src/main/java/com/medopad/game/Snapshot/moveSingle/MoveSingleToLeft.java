package com.medopad.game.Snapshot.moveSingle;

import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveSingleToLeft extends MoveSingle {
    public MoveSingleToLeft(Snapshot from, Direction direction) {
        super(from, direction);
    }

    @Override
    void setSpaceButtons(Direction direction) {
        this.space1.x -= OFFSET;
    }
}
