package com.medopad.test;

import com.medopad.game.PointConstant;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;
import com.medopad.game.Snapshot.SnapshotFactory;
import com.medopad.game.Snapshot.moveHorizon.MoveHorPiece;
import com.medopad.game.Snapshot.moveSingle.MoveSingle;
import org.junit.Test;

public class TestSnapshotFactory {
    private String[][] maps = new String[][] {
            new String[] {"X", "X", "X", "X", "X", "X"},
            new String[] {"X", "A", "6", "7", "H", "X"},
            new String[] {"X", "O", "8", "9", "K", "X"},
            new String[] {"X", "B", "E", "L", "I", "X"},
            new String[] {"X", "M", "F", "G", "N", "X"},
            new String[] {"X", "C", " ", " ", "J", "X"},
            new String[] {"X", "X", "Z", "Z", "X", "X"}
    };

    @Test
    public void testPrintHelper() {
        Direction d = Direction.LEFT;
        Snapshot snapshot = new Snapshot(maps);
        for (String p : PointConstant.SINGLE_PIECE_SET) {
            assert SnapshotFactory.getSnapshot(p, d, snapshot) instanceof MoveSingle;
        }

        assert SnapshotFactory.getSnapshot(PointConstant.HOR_PIECE_LEFT, d, snapshot) == null;
        assert SnapshotFactory.getSnapshot(PointConstant.HOR_PIECE_LEFT, Direction.RIGHT, snapshot) instanceof MoveHorPiece;
        assert SnapshotFactory.getSnapshot(PointConstant.HOR_PIECE_RIGHT, Direction.RIGHT, snapshot) == null;
        assert SnapshotFactory.getSnapshot(PointConstant.HOR_PIECE_RIGHT, d, snapshot) instanceof MoveHorPiece;

    }






}
