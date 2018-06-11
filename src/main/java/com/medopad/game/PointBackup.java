package com.medopad.game;

import com.medopad.game.Snapshot.Direction;

import java.util.*;

public class PointBackup {

    public static Set<String> LEGAL_CHARACTERS = new HashSet<>(Arrays.asList("A","B", "C","D", "E", "F", "G", "H", "I", "J", "Z", "X", " "));
    public static final Set<String> SINGLE_PIECE_SET = new HashSet<>(Arrays.asList("C", "F", "G", "J"));
    public static final String HOR_PIECE_LEFT = "E";
    public static final String HOR_PIECE_RIGHT = "L";
    public static final Map<String, String> VERTICAL_PIECE = createMap();
    public static final Map<String, String> VERTICAL_BOTTOM_TO_TOP = createVerticalBottomToTopMap();

    private static Map<String, String> createVerticalBottomToTopMap() {
        Map<String,String> myMap = new HashMap<>();
        myMap.put("O", "A");
        myMap.put("K", "H");
        myMap.put("M", "B");
        myMap.put("N", "I");
        return myMap;
    }

    private static Map<String, String> createMap() {
        Map<String,String> myMap = new HashMap<>();
        myMap.put("A", "O");
        myMap.put("H", "K");
        myMap.put("B", "M");
        myMap.put("I", "N");
        return myMap;
    }
    public static final String D_PIECE_LEFT_TOP = "6";
    public static final String D_PIECE_RIGHT_TOP = "7";
    public static final String D_PIECE_LEFT_BOT = "8";
    public static final String D_PIECE_RIGHT_BOT = "9";
    public static final String D_PIECE = "D";


    public static final String EXIT_CHARACTER = "Z";
    public static final String BORDER = "X";

    public static final String SPACE = " ";

    public int x;
    public int y;

    public PointBackup(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PointBackup(PointBackup other) {
        this.x = other.x;
        this.y = other.y;
    }

    public PointBackup getNeighbour(Direction d) {
        switch (d) {
            case LEFT: return left();
            case UP:return up();
            case DOWN: return down();
            case RIGHT:return right();
            default: return null;
        }
    }

    public PointBackup left() {
        return new PointBackup(x - 1, y);
    }
    public PointBackup right() {
        return new PointBackup(x + 1, y);
    }
    public PointBackup up() {
        return new PointBackup(x, y - 1);
    }
    public PointBackup down() {
        return new PointBackup(x, y + 1);
    }

    public PointBackup offsetX(int step) {
        return new PointBackup(x + step, y);
    }
    public PointBackup offsetY(int step) {
        return new PointBackup(x, y + step);
    }

    public PointBackup offset(int stepX, int stepY)
    {
        return new PointBackup(x + stepX, y + stepY);
    }


    public static boolean isSinglePiece(String s) {
        return SINGLE_PIECE_SET.contains(s);
    }

    public static boolean belongsToVerticalPiece(String s) {
        return  belongsToVerticalPieceTop(s) || belongsToVerticalPieceBottom(s);
    }

    public static boolean belongsToVerticalPieceTop(String s) {
        return VERTICAL_PIECE.containsKey(s);
    }
    public static boolean belongsToVerticalPieceBottom(String s) {
        return VERTICAL_PIECE.containsValue(s);
    }

    public static boolean belongsToHorizonPiece(String s) {
        return s.equals(HOR_PIECE_RIGHT) || s.equals(HOR_PIECE_LEFT);
    }

    public static boolean belongsToDPiece(String s) {
        return s.equals(D_PIECE_LEFT_TOP) || s.equals(D_PIECE_RIGHT_TOP) || s.equals(D_PIECE_LEFT_BOT) || s.equals(D_PIECE_RIGHT_BOT);
    }

    public static String getBottomPieceFromTop(String piece) {
        return VERTICAL_PIECE.get(piece);
    }
    public static String getTopPieceFromBottom(String piece) {
        return VERTICAL_BOTTOM_TO_TOP.get(piece);
    }
}
