package com.medopad.game;

public class MapsBackup {
    protected String[][] maps;
    private int cols;
    private int rows;

    public static final int EXIT_SIZE = 2;

    public MapsBackup(String[][] maps) {
        this.maps = maps;
        this.rows = maps.length;
        this.cols = maps[0].length;
    }

    public MapsBackup(MapsBackup other) {
        this.maps = other.maps.clone();
        this.rows = other.rows;
        this.cols = other.cols;
    }

    public String get(PointBackup position) {
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

    public void set(PointBackup position, String val) {
        set(position.x, position.y, val);
    }

    public void set(int x, int y, String val) {
        maps[y][x] = val;
    }

    public PointBackup[] space() {
        PointBackup[] points = new PointBackup[EXIT_SIZE];
        int index = 0;
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                if (get(j, i).equals(PointBackup.SPACE)) {
                    points[index] = new PointBackup(j, i);
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
                sb.append(s);
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
        if (s.equals("O"))
            return "A";
        if (s.equals("M"))
                    return "B";
        if (s.equals("N"))
                    return "I";
        if (s.equals("K"))
                    return "H";
        if (s.equals("L"))
                    return "E";
        if (PointBackup.belongsToDPiece(s))
            return PointBackup.D_PIECE;
        return s;
    }
}
