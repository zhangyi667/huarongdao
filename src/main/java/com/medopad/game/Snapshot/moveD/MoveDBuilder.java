package com.medopad.game.Snapshot.moveD;

import com.medopad.game.PointBackup;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveDBuilder {
    public static MoveDPiece build(String val, Snapshot snapshot, Direction direction) {
        switch (direction) {
            case LEFT: {
                if (val.equals(PointBackup.D_PIECE_RIGHT_TOP)  && snapshot.getMaps().get(snapshot.getSpace1().down()).equals(PointBackup.SPACE)) {
                    return new MoveDPieceLeft(snapshot, direction, val);
                } else if (val.equals(PointBackup.D_PIECE_RIGHT_BOT) && snapshot.getMaps().get(snapshot.getSpace1().up()).equals(PointBackup.SPACE)) {
                    return new MoveDPieceLeft(snapshot, direction, val) {
                        public void movePiece(PointBackup point, String val) {
                            this.maps.set(point, val);
                            this.maps.set(point.up(), PointBackup.D_PIECE_RIGHT_TOP);
                            this.maps.set(point.left(), PointBackup.D_PIECE_LEFT_BOT);
                            this.maps.set(point.offset(-1, -1), PointBackup.D_PIECE_LEFT_TOP);
                            this.maps.set(point.offsetX(-2), PointBackup.SPACE);
                            this.maps.set(point.offset(-2, -1), PointBackup.SPACE);
                        }
                    };
                }
                return null;
            }

            case RIGHT: {
                if (val.equals(PointBackup.D_PIECE_LEFT_TOP) && snapshot.getMaps().get(snapshot.getSpace1().down()).equals(PointBackup.SPACE)) {
                    return new MoveDPieceRight(snapshot, direction, val);
                } else if (val.equals(PointBackup.D_PIECE_LEFT_BOT) && snapshot.getMaps().get(snapshot.getSpace1().up()).equals(PointBackup.SPACE)) {
                    return new MoveDPieceRight(snapshot, direction, val){
                        public void movePiece(PointBackup point, String val) {
                            this.maps.set(point, val);
                            this.maps.set(point.up(), PointBackup.D_PIECE_LEFT_TOP);
                            this.maps.set(point.right(), PointBackup.D_PIECE_RIGHT_BOT);
                            this.maps.set(point.offset(+1, -1), PointBackup.D_PIECE_RIGHT_TOP);
                            this.maps.set(point.offsetX(+2), PointBackup.SPACE);
                            this.maps.set(point.offset(+2, -1), PointBackup.SPACE);
                        }
                    };
                }
                return null;
            }

            case UP: {
                if (val.equals(PointBackup.D_PIECE_LEFT_BOT) && snapshot.getMaps().get(snapshot.getSpace1().right()).equals(PointBackup.SPACE)) {
                    return new MoveDPieceUp(snapshot, direction, val);
                } else if (val.equals(PointBackup.D_PIECE_RIGHT_BOT) && snapshot.getMaps().get(snapshot.getSpace1().left()).equals(PointBackup.SPACE)) {
                    return new MoveDPieceUp(snapshot, direction, val) {
                        public void movePiece(PointBackup point, String val) {
                            this.maps.set(point, val);
                            this.maps.set(point.left(), PointBackup.D_PIECE_LEFT_BOT);
                            this.maps.set(point.up(), PointBackup.D_PIECE_RIGHT_TOP);
                            this.maps.set(point.offset(-1, -1), PointBackup.D_PIECE_LEFT_TOP);
                            this.maps.set(point.offsetY(-2), PointBackup.SPACE);
                            this.maps.set(point.offset(-1, -2), PointBackup.SPACE);
                        }
                    };
                }
                return null;
            }
            case DOWN:
                if (val.equals(PointBackup.D_PIECE_LEFT_TOP) && snapshot.getMaps().get(snapshot.getSpace1().right()).equals(PointBackup.SPACE)) {
                    return new MoveDPieceDown(snapshot, direction, val);
                } else if (val.equals(PointBackup.D_PIECE_RIGHT_TOP) && snapshot.getMaps().get(snapshot.getSpace1().left()).equals(PointBackup.SPACE)) {
                    return new MoveDPieceDown(snapshot, direction, val){
                        public void movePiece(PointBackup point, String val) {
                            this.maps.set(point, val);
                            this.maps.set(point.left(), PointBackup.D_PIECE_LEFT_TOP);
                            this.maps.set(point.down(), PointBackup.D_PIECE_RIGHT_BOT);
                            this.maps.set(point.offset(-1, +1), PointBackup.D_PIECE_LEFT_BOT);
                            this.maps.set(point.offsetY(+2), PointBackup.SPACE);
                            this.maps.set(point.offset(-1, +2), PointBackup.SPACE);
                        }
                    };
                }

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
        return (val.equals(PointBackup.HOR_PIECE_LEFT) && snapshot.getMaps().get(snapshot.getSpace1().right()).equals(PointBackup.SPACE)) ||
                (val.equals(PointBackup.HOR_PIECE_RIGHT) && snapshot.getMaps().get(snapshot.getSpace1().left()).equals(PointBackup.SPACE));
    }
}
