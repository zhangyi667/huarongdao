package com.medopad.game.Snapshot;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.moveD.MoveDBuilder;
import com.medopad.game.Snapshot.moveHorizon.MoveHorizonBuilder;
import com.medopad.game.Snapshot.moveSingle.MoveSingleBuilder;
import com.medopad.game.Snapshot.moveVertical.MoveVerticalBuilder;

public class SnapshotFactory {

    public static Snapshot getSnapshot(int val, Direction direction, Snapshot snapshot) {
        if (Point.isSinglePiece(val)) {
            return MoveSingleBuilder.build(snapshot, direction);
        } else if (Point.belongsToHorizonPiece(val)) {
            return MoveHorizonBuilder.build(val, snapshot, direction);
        } else if (Point.belongsToVertivalPiece(val)) {
            return MoveVerticalBuilder.build(val, snapshot, direction);
        } else if (Point.belongsToDPiece(val)) {
            return MoveDBuilder.build(val, snapshot, direction);
        }
        return null;
    }
}
