package com.medopad.game.Snapshot.moveVertical;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveVerticalBuilder {
    public static MoveVerPiece build(String val, Snapshot snapshot, Direction direction) {
        switch (direction) {
            case LEFT: {
               if (hasEnoughSpaceToMoveLeft(val, snapshot)) {
                   return new MoveVerPieceLeft(snapshot, direction, val);
               }
               return null;
             }
            case RIGHT: {
                if (hasEnoughSpaceToMoveRight(val,snapshot)) {
                    return new MoveVerPieceRight(snapshot, direction, val);
                }
                return null;
            }
            case UP: {
                if (Point.belongsToVerticalPieceBottom(val)) {
                    return new MoveVerPieceUp(snapshot, direction, val);
                }
                return null;
            }
            case DOWN:
                if (Point.belongsToVerticalPieceTop(val)) {
                    return new MoveVerPieceDown(snapshot, direction, val);
                }
                return null;
            default:
                return null;

        }
    }

    private static boolean hasEnoughSpaceToMoveRight(String val, Snapshot snapshot) {
        return hasEnoughSpace(val, snapshot);
    }

    private static boolean hasEnoughSpaceToMoveLeft(String val, Snapshot snapshot) {
        return hasEnoughSpace(val, snapshot);
    }

    private static boolean hasEnoughSpace(String val, Snapshot snapshot) {
        return (Point.belongsToVerticalPieceTop(val) && snapshot.getMaps().get(snapshot.getSpace1().down()).equals(Point.SPACE)) ||
                (Point.belongsToVerticalPieceBottom(val) && snapshot.getMaps().get(snapshot.getSpace1().up()).equals(Point.SPACE));
    }

}
