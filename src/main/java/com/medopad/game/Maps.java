package com.medopad.game;

public class Maps {
    protected String[][] maps;
    private int cols;
    private int rows;

    public static final int EXIT_SIZE = 2;

    public Maps(String[][] maps) {
        this.maps = maps;
        this.rows = maps.length;
        this.cols = maps[0].length;
    }

    public Maps(Maps other) {
        this.maps = cloneMaps(other);
        this.rows = other.rows;
        this.cols = other.cols;
    }

    private String[][] cloneMaps(Maps other) {
        String[][] res = new String[other.rows][other.cols];
        for (int i = 0; i < other.rows; i++) {
            res[i] = other.maps[i].clone();
        }
        return res;
    }
    public String get(Point position) {
        return get(position.x, position.y);
    }

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    public String get(int x, int y) {
        return maps[y][x];
    }

    public void set(Point position, String val) {
        set(position.x, position.y, val);
    }

    public void set(int x, int y, String val) {
        maps[y][x] = val;
    }

    public Point[] space() {
        Point[] points = new Point[EXIT_SIZE];
        int index = 0;
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                if (get(j, i).equals(PointConstant.SPACE)) {
                    points[index] = new Point(j, i);
                    index++;
                }
            }
        }
        return points;
    }

    public String hashKeys() {
        StringBuilder sb = new StringBuilder();
        for (String[] row : maps) {
            for (String s : row) {
                if (Point.isSinglePiece(s)) sb.append(PointConstant.SINGLE_PIECE);
                else if (Point.belongsToVerticalPiece(s)) sb.append(PointConstant.V_PIECE);
                else if (Point.belongsToHorizonPiece(s)) sb.append(PointConstant.HOR_PIECE_LEFT);
                else if (Point.belongsToDPiece(s)) sb.append(PointConstant.D_PIECE);
                else sb.append(s);
            }
        }
        return sb.toString();
    }

    public void print() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j <  getCols(); j++) {
                System.out.print(printHelper(get(j, i)) + " ");
            }
            System.out.println();
        }
    }

    private String printHelper(String s) {
        if (s.equals(PointConstant.V_PIECE_AVATAR_1))
            return PointConstant.V_PIECE;
        if (s.equals(PointConstant.V_PIECE_AVATAR_3))
                    return PointConstant.V_PIECE_2;
        if (s.equals(PointConstant.V_PIECE_AVATAR_4))
                    return PointConstant.V_PIECE_3;
        if (s.equals(PointConstant.V_PIECE_AVATAR_2))
                    return PointConstant.V_PIECE_4;
        if (s.equals(PointConstant.HOR_PIECE_RIGHT))
                    return PointConstant.HOR_PIECE_LEFT;
        if (Point.belongsToDPiece(s))
            return PointConstant.D_PIECE;
        return s;
    }
}
