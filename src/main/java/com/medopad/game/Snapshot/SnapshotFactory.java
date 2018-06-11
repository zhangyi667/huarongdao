package com.medopad.game.Snapshot;

import com.medopad.game.PointBackup;
import com.medopad.game.Snapshot.moveD.MoveDBuilder;
import com.medopad.game.Snapshot.moveHorizon.MoveHorizonBuilder;
import com.medopad.game.Snapshot.moveSingle.MoveSingleBuilder;
import com.medopad.game.Snapshot.moveVertical.MoveVerticalBuilder;

public class SnapshotFactory {

    public static Snapshot getSnapshot(String val, Direction direction, Snapshot snapshot) {
        if (PointBackup.isSinglePiece(val)) {
            return MoveSingleBuilder.build(snapshot, direction);
        } else if (PointBackup.belongsToHorizonPiece(val)) {
            return MoveHorizonBuilder.build(val, snapshot, direction);
        } else if (PointBackup.belongsToVerticalPiece(val)) {
            return MoveVerticalBuilder.build(val, snapshot, direction);
        } else if (PointBackup.belongsToDPiece(val)) {
            return MoveDBuilder.build(val, snapshot, direction);
        }
        return null;
    }
}
