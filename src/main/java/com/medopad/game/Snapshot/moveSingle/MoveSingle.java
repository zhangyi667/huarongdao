package com.medopad.game.Snapshot.moveSingle;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public abstract class MoveSingle extends Snapshot {

    Direction direction;

    static final int OFFSET = 1;

    MoveSingle(Snapshot from, Direction direction) {
        super(from);
        this.direction = direction;
        setSpaceButtons(direction);
    }

    abstract void setSpaceButtons(Direction direction);


    public void movePiece(Point point, String val) {
        this.maps.set(point, val);
        this.maps.set(point.getNeighbour(this.direction), Point.SPACE);
    }
}
