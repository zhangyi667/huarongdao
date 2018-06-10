package com.medopad.game;

import java.util.Arrays;

public class Maps {
    protected int[] maps;
    public int cols;
    public int rows;

    private static final int EXIT_SIZE = 2;
    private static final int EXIT = 0;

    public Maps(int[] maps, int rows, int cols) {
        this.maps = maps;
        this.rows = rows;
        this.cols = cols;
    }

    public Maps(Maps other) {
        this.maps = other.maps.clone();
        this.rows = other.rows;
        this.cols = other.cols;
    }

    public int get(Point position) {
        return get(position.x, position.y);
    }

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    public int get(int x, int y) {
        return maps[y * cols + x];
    }

    public void set(Point position, int val) {
        set(position.x, position.y, val);
    }

    public void set(int x, int y, int val) {
        maps[y * cols + x] = val;
    }

    public Point[] space() {
        Point[] points = new Point[EXIT_SIZE];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (get(j, i) == EXIT) {
                    points[index] = new Point(j, i);
                    index++;
                }
            }
        }

        return points;
    }

    public String hashKeys() {
        return Arrays.toString(maps);
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(get(j, i) + " ");
            }
            System.out.println();
        }
    }
}
