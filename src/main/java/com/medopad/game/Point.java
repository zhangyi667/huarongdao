package com.medopad.game;

import com.medopad.game.Snapshot.Direction;

public class Point {


    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    public Point getNeighbour(Direction d) {
        switch (d) {
            case LEFT: return left();
            case UP:return up();
            case DOWN: return down();
            case RIGHT:return right();
            default: return null;
        }
    }

    public Point left() {
        return new Point(x - 1, y);
    }
    public Point right() {
        return new Point(x + 1, y);
    }
    public Point up() {
        return new Point(x, y - 1);
    }
    public Point down() {
        return new Point(x, y + 1);
    }

    public Point offsetX(int step) {
        return new Point(x + step, y);
    }
    public Point offsetY(int step) {
        return new Point(x, y + step);
    }

    public Point offset(int stepX, int stepY)
    {
        return new Point(x + stepX, y + stepY);
    }


    public static boolean isSinglePiece(String s) {
        return PointConstant.SINGLE_PIECE_SET.contains(s);
    }

    public static boolean belongsToVerticalPiece(String s) {
        return  belongsToVerticalPieceTop(s) || belongsToVerticalPieceBottom(s);
    }

    public static boolean belongsToVerticalPieceTop(String s) {
        return PointConstant.VERTICAL_PIECE.containsKey(s);
    }
    public static boolean belongsToVerticalPieceBottom(String s) {
        return PointConstant.VERTICAL_PIECE.containsValue(s);
    }

    public static boolean belongsToHorizonPiece(String s) {
        return s.equals(PointConstant.HOR_PIECE_RIGHT) || s.equals(PointConstant.HOR_PIECE_LEFT);
    }

    public static boolean belongsToDPiece(String s) {
        return s.equals(PointConstant.D_PIECE_LEFT_TOP) || s.equals(PointConstant.D_PIECE_RIGHT_TOP) || s.equals(PointConstant.D_PIECE_LEFT_BOT) || s.equals(PointConstant.D_PIECE_RIGHT_BOT);
    }

    public static String getBottomPieceFromTop(String piece) {
        return PointConstant.VERTICAL_PIECE.get(piece);
    }
    public static String getTopPieceFromBottom(String piece) {
        return PointConstant.VERTICAL_BOTTOM_TO_TOP.get(piece);
    }
}
