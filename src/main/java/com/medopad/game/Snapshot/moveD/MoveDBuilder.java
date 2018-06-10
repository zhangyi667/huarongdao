package com.medopad.game.Snapshot.moveD;

import com.medopad.game.Point;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveDBuilder {
    public static MoveDPiece build(int val, Snapshot snapshot, Direction direction) {
        switch (direction) {
            case LEFT: {
                if (val == Point.D_PIECE_RIGHT_TOP && snapshot.getMaps().get(snapshot.getSpace1().down()) == Point.SPACE) {
                    return new MoveDPieceLeft(snapshot, direction, val);
                } else if (val == Point.D_PIECE_RIGHT_BOT && snapshot.getMaps().get(snapshot.getSpace1().up()) == Point.SPACE) {
                    return new MoveDPieceLeft(snapshot, direction, val) {
                        public void movePiece(Point point, int val) {
                            this.maps.set(point, val);
                            this.maps.set(point.up(), Point.D_PIECE_RIGHT_TOP);
                            this.maps.set(point.left(), Point.D_PIECE_LEFT_BOT);
                            this.maps.set(point.offset(-1, -1), Point.D_PIECE_LEFT_TOP);
                            this.maps.set(point.offsetX(-2), Point.SPACE);
                            this.maps.set(point.offset(-2, -1), Point.SPACE);
                        }
                    };
                }
                return null;
            }

            case RIGHT: {
                if (val == Point.D_PIECE_LEFT_TOP && snapshot.getMaps().get(snapshot.getSpace1().down()) == Point.SPACE) {
                    return new MoveDPieceRight(snapshot, direction, val);
                } else if (val == Point.D_PIECE_LEFT_BOT && snapshot.getMaps().get(snapshot.getSpace1().up()) == Point.SPACE) {
                    return new MoveDPieceRight(snapshot, direction, val){
                        public void movePiece(Point point, int val) {
                            this.maps.set(point, val);
                            this.maps.set(point.up(), Point.D_PIECE_LEFT_TOP);
                            this.maps.set(point.right(), Point.D_PIECE_RIGHT_BOT);
                            this.maps.set(point.offset(+1, -1), Point.D_PIECE_RIGHT_TOP);
                            this.maps.set(point.offsetX(+2), Point.SPACE);
                            this.maps.set(point.offset(+2, -1), Point.SPACE);
                        }
                    };
                }
                return null;
            }

            case UP: {
                if (val == Point.D_PIECE_LEFT_BOT && snapshot.getMaps().get(snapshot.getSpace1().right()) == Point.SPACE) {
                    return new MoveDPieceUp(snapshot, direction, val);
                } else if (val == Point.D_PIECE_RIGHT_BOT && snapshot.getMaps().get(snapshot.getSpace1().left()) == Point.SPACE) {
                    return new MoveDPieceUp(snapshot, direction, val) {
                        public void movePiece(Point point, int val) {
                            this.maps.set(point, val);
                            this.maps.set(point.left(), Point.D_PIECE_LEFT_BOT);
                            this.maps.set(point.up(), Point.D_PIECE_RIGHT_TOP);
                            this.maps.set(point.offset(-1, -1), Point.D_PIECE_LEFT_TOP);
                            this.maps.set(point.offsetY(-2), Point.SPACE);
                            this.maps.set(point.offset(-1, -2), Point.SPACE);
                        }
                    };
                }
                return null;
            }
            case DOWN:
                if (val == Point.D_PIECE_LEFT_TOP && snapshot.getMaps().get(snapshot.getSpace1().right()) == Point.SPACE) {
                    return new MoveDPieceDown(snapshot, direction, val);
                } else if (val == Point.D_PIECE_RIGHT_TOP && snapshot.getMaps().get(snapshot.getSpace1().left()) == Point.SPACE) {
                    return new MoveDPieceDown(snapshot, direction, val){
                        public void movePiece(Point point, int val) {
                            this.maps.set(point, val);
                            this.maps.set(point.left(), Point.D_PIECE_LEFT_TOP);
                            this.maps.set(point.down(), Point.D_PIECE_RIGHT_BOT);
                            this.maps.set(point.offset(-1, +1), Point.D_PIECE_LEFT_BOT);
                            this.maps.set(point.offsetY(+2), Point.SPACE);
                            this.maps.set(point.offset(-1, +2), Point.SPACE);
                        }
                    };
                }

                return null;
            default:
                return null;
        }
    }

    private static boolean hasSpaceToMoveUp(int val, Snapshot snapshot) {
        return hasEnoughSpace(val, snapshot);
    }

    private static boolean hasSpaceToMoveDown(int val, Snapshot snapshot) {
        return hasEnoughSpace(val, snapshot);
    }

    private static boolean hasEnoughSpace(int val, Snapshot snapshot) {
        return (val == Point.HOR_PIECE_LEFT && snapshot.getMaps().get(snapshot.getSpace1().right()) == Point.SPACE) ||
                (val == Point.HOR_PIECE_RIGHT && snapshot.getMaps().get(snapshot.getSpace1().left()) == Point.SPACE);
    }
}
