package com.medopad.game.Snapshot.moveVertical;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveVerticalBuilder {
    public static MoveVerPiece build(int val, Snapshot snapshot, Direction direction) {
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
                if (val == Point.VERTICAL_PIECE_BOTTOM) {
                    return new MoveVerPieceUp(snapshot, direction, val);
                }
                return null;
            }
            case DOWN:
                if (val == Point.VERTICAL_PIECE_TOP) {
                    return new MoveVerPieceDown(snapshot, direction, val);
                }
                return null;
            default:
                return null;

        }
    }

    private static boolean hasEnoughSpaceToMoveRight(int val, Snapshot snapshot) {
        return hasEnoughSpace(val, snapshot);
    }

    private static boolean hasEnoughSpaceToMoveLeft(int val, Snapshot snapshot) {
        return hasEnoughSpace(val, snapshot);
    }

    private static boolean hasEnoughSpace(int val, Snapshot snapshot) {
        return (val == Point.VERTICAL_PIECE_TOP && snapshot.getMaps().get(snapshot.getSpace1().down()) == Point.SPACE) ||
                (val == Point.VERTICAL_PIECE_BOTTOM && snapshot.getMaps().get(snapshot.getSpace1().up()) == Point.SPACE);
    }

}
