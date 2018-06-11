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
    public String get(PointConstant.Point position) {
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

    public void set(PointConstant.Point position, String val) {
        set(position.x, position.y, val);
    }

    public void set(int x, int y, String val) {
        maps[y][x] = val;
    }

    public PointConstant.Point[] space() {
        PointConstant.Point[] points = new PointConstant.Point[EXIT_SIZE];
        int index = 0;
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                if (get(j, i).equals(PointConstant.Point.SPACE)) {
                    points[index] = new PointConstant.Point(j, i);
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
                if (PointConstant.Point.isSinglePiece(s)) sb.append(PointConstant.Point.SINGLE_PIECE);
                else if (PointConstant.Point.belongsToVerticalPiece(s)) sb.append(PointConstant.Point.V_PIECE);
                else if (PointConstant.Point.belongsToHorizonPiece(s)) sb.append(PointConstant.Point.HOR_PIECE_LEFT);
                else if (PointConstant.Point.belongsToDPiece(s)) sb.append(PointConstant.Point.D_PIECE);
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
        if (s.equals(PointConstant.Point.V_PIECE_AVATAR_1))
            return PointConstant.Point.V_PIECE;
        if (s.equals(PointConstant.Point.V_PIECE_AVATAR_3))
                    return PointConstant.Point.V_PIECE_2;
        if (s.equals(PointConstant.Point.V_PIECE_AVATAR_4))
                    return PointConstant.Point.V_PIECE_3;
        if (s.equals(PointConstant.Point.V_PIECE_AVATAR_2))
                    return PointConstant.Point.V_PIECE_4;
        if (s.equals(PointConstant.Point.HOR_PIECE_RIGHT))
                    return PointConstant.Point.HOR_PIECE_LEFT;
        if (PointConstant.Point.belongsToDPiece(s))
            return PointConstant.Point.D_PIECE;
        return s;
    }
}
