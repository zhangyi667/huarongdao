package com.medopad.game;

import com.medopad.game.Snapshot.Direction;

import java.util.*;

public class PointConstant {
    public static class Point {

        public static final String D_PIECE = "D";
        public static final String D_PIECE_LEFT_TOP = "6";
        public static final String D_PIECE_RIGHT_TOP = "7";
        public static final String D_PIECE_LEFT_BOT = "8";
        public static final String D_PIECE_RIGHT_BOT = "9";

        public static final String SINGLE_PIECE = "C";
        public static final String SINGLE_PIECE_2 = "F";
        public static final String SINGLE_PIECE_3 = "G";
        public static final String SINGLE_PIECE_4 = "J";

        public static final String V_PIECE = "A";
        public static final String V_PIECE_2 = "B";
        public static final String V_PIECE_3 = "I";
        public static final String V_PIECE_4 = "H";

        public static final String V_PIECE_AVATAR_1 = "O";
        public static final String V_PIECE_AVATAR_2 = "K";
        public static final String V_PIECE_AVATAR_3 = "M";
        public static final String V_PIECE_AVATAR_4 = "N";

        public static final String HOR_PIECE_LEFT = "E";
        public static final String HOR_PIECE_RIGHT = "L";

        public static final String EXIT_CHARACTER = "Z";
        public static final String BORDER = "X";

        public static final String SPACE = " ";

        public static Set<String> LEGAL_CHARACTERS = new HashSet<>(Arrays.asList(V_PIECE,V_PIECE_2, SINGLE_PIECE,D_PIECE, HOR_PIECE_LEFT, SINGLE_PIECE_2, SINGLE_PIECE_3, V_PIECE_4, V_PIECE_3, SINGLE_PIECE_4, EXIT_CHARACTER, BORDER, SPACE));
        public static final Set<String> SINGLE_PIECE_SET = new HashSet<>(Arrays.asList(SINGLE_PIECE, SINGLE_PIECE_2, SINGLE_PIECE_3, SINGLE_PIECE_4));
        public static final Map<String, String> VERTICAL_PIECE = createMap();
        public static final Map<String, String> VERTICAL_BOTTOM_TO_TOP = createVerticalBottomToTopMap();

        private static Map<String, String> createVerticalBottomToTopMap() {
            Map<String,String> myMap = new HashMap<>();
            myMap.put(V_PIECE_AVATAR_1, V_PIECE);
            myMap.put(V_PIECE_AVATAR_2, V_PIECE_4);
            myMap.put(V_PIECE_AVATAR_3, V_PIECE_2);
            myMap.put(V_PIECE_AVATAR_4, V_PIECE_3);
            return myMap;
        }

        private static Map<String, String> createMap() {
            Map<String,String> myMap = new HashMap<>();
            myMap.put(V_PIECE, V_PIECE_AVATAR_1);
            myMap.put(V_PIECE_4, V_PIECE_AVATAR_2);
            myMap.put(V_PIECE_2, V_PIECE_AVATAR_3);
            myMap.put(V_PIECE_3, V_PIECE_AVATAR_4);
            return myMap;
        }


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
}
