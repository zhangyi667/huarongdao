package com.medopad.game;

import com.medopad.game.Snapshot.Direction;

public class Point {

    public static final int SINGLE_PIECE = 1;
    public static final int HOR_PIECE_LEFT = 2;
    public static final int HOR_PIECE_RIGHT = 3;
    public static final int VERTICAL_PIECE_TOP = 4;
    public static final int VERTICAL_PIECE_BOTTOM = 5;
    public static final int D_PIECE_LEFT_TOP = 6;
    public static final int D_PIECE_RIGHT_TOP = 7;
    public static final int D_PIECE_LEFT_BOT = 8;
    public static final int D_PIECE_RIGHT_BOT = 9;

    public static final int SPACE = 0;

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


    public boolean isSinglePiece(int val) {
        return val == SINGLE_PIECE;
    }

    public boolean belongsToVertivalPiece(int val) {
        return val == VERTICAL_PIECE_BOTTOM || val == VERTICAL_PIECE_TOP;
    }

    public boolean belongsToHorizonPiece(int val) {
        return val == HOR_PIECE_RIGHT || val == HOR_PIECE_LEFT;
    }

    public boolean belongsToDPiece(int val) {
        return val > 6;
    }
}
