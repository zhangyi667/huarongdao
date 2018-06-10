package com.medopad.game.Snapshot;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.moveD.MoveDBuilder;
import com.medopad.game.Snapshot.moveHorizon.MoveHorizonBuilder;
import com.medopad.game.Snapshot.moveSingle.MoveSingleBuilder;
import com.medopad.game.Snapshot.moveVertical.MoveVerticalBuilder;

public class SnapshotFactory {

    public static Snapshot getSnapshot(int val, Direction direction, Snapshot snapshot) {
        if (val == Point.SINGLE_PIECE) {
            return MoveSingleBuilder.build(snapshot, direction);
        } else if (val == Point.HOR_PIECE_RIGHT || val == Point.HOR_PIECE_LEFT) {
            return MoveHorizonBuilder.build(val, snapshot, direction);
        } else if (val == Point.VERTICAL_PIECE_TOP || val == Point.VERTICAL_PIECE_BOTTOM) {
            return MoveVerticalBuilder.build(val, snapshot, direction);
        } else if (val >= 6) {
            return MoveDBuilder.build(val, snapshot, direction);
        }
        return null;
    }
}
