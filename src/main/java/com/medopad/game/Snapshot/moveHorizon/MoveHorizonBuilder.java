package com.medopad.game.Snapshot.moveHorizon;

import com.medopad.game.PointConstant;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveHorizonBuilder {
    public static MoveHorPiece build(String val, Snapshot snapshot, Direction direction) {
        switch (direction) {
            case LEFT: {
                if (val.equals(PointConstant.HOR_PIECE_RIGHT))
                    return new MoveHorPieceLeft(snapshot, direction, val);
                return null;
            }
            case RIGHT: {
                if (val.equals(PointConstant.HOR_PIECE_LEFT))
                    return new MoveHorPieceRight(snapshot, direction, val);
                return null;
            }
            case UP: {
                if (hasSpaceToMoveUp(val, snapshot)) {
                    return new MoveHorPieceUp(snapshot, direction, val);
                }
                return null;
            }
            case DOWN:
                if (hasSpaceToMoveDown(val, snapshot))
                    return new MoveHorPieceDown(snapshot, direction, val);
                return null;
            default:
                return null;
        }
    }

    private static boolean hasSpaceToMoveUp(String val, Snapshot snapshot) {
        return hasEnoughSpace(val, snapshot);
    }

    private static boolean hasSpaceToMoveDown(String val, Snapshot snapshot) {
        return hasEnoughSpace(val, snapshot);
    }

    private static boolean hasEnoughSpace(String val, Snapshot snapshot) {
        return (val.equals(PointConstant.HOR_PIECE_LEFT) && snapshot.getMaps().get(snapshot.getSpace1().right()).equals(PointConstant.SPACE)) ||
                (val == PointConstant.HOR_PIECE_RIGHT && snapshot.getMaps().get(snapshot.getSpace1().left()).equals(PointConstant.SPACE));
    }
}
