package com.medopad.game.Snapshot.moveSingle;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public abstract class MoveSingle extends Snapshot {

    Direction direction;

    protected static final int OFFSET = 1;

    public MoveSingle(Snapshot from, Direction direction) {
        super(from);
        this.direction = direction;
        setSpaceButtons(direction);
    }

    abstract void setSpaceButtons(Direction direction);
//    {
//        if (direction == Direction.LEFT) {
//            this.space1.x -= OFFSET;
//        } else if (direction == Direction.RIGHT) {
//            this.space1.x += OFFSET;
//        } else if (direction == Direction.UP) {
//            this.space1.y -= OFFSET;
//        } else if (direction == Direction.DOWN) {
//            this.space1.y += OFFSET;
//        }
//    }


    public void movePiece(Point point, int val) {
        this.maps.set(point, val);
        this.maps.set(point.getNeighbour(this.direction), Point.SPACE);
    }
}
