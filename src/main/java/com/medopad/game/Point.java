package com.medopad.game;

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
}
