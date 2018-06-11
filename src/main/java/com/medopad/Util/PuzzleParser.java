package com.medopad.Util;

import com.medopad.game.Maps;
import com.medopad.game.Point;
import com.medopad.game.PointConstant;

public class PuzzleParser {

    public static String[][] parse(String[][] input) {
        if (null == input || input.length < 2 || input[0].length < 1)
            throw new IllegalArgumentException("Input can't be null or empty");
        int row = input.length;
        int col = input[0].length;
        String[][] res = new String[row][col];
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            String[] newRow = input[i];
            if (newRow.length != col)
                throw new IllegalArgumentException();
            if (borderInvalid(newRow, col))
                throw new IllegalArgumentException();
            for (int j = 0; j < col; j++) {
                if (visited[i][j]) continue;
                String piece = newRow[j];
                if (!PointConstant.LEGAL_CHARACTERS.contains(piece)) {
                    throw new IllegalArgumentException(String.format("%s is not a valid input", piece));
                }
                if (PointConstant.BORDER.equals(piece) || PointConstant.SPACE.equals(piece) || PointConstant.EXIT_CHARACTER.equals(piece)) {
                    res[i][j] = piece;
                    visited[i][j] = true;
                    continue;
                }
                if (isVerticalPiece(piece)) {
                    if (!isValidVerticalPiece(input, i, j)) {
                        throw new IllegalArgumentException();
                    }
                    parseVerticalPiece(input, res, i, j, visited);
                } else if (isHorizonPiece(piece)) {
                    if (!isValidHorPiece(input, i, j)) {
                        throw new IllegalArgumentException();
                    }
                    parseHorPiece(input, res, i, j, visited);
                } else if (isDPiece(piece)) {
                    if (!isValidDPiece(input, i, j)) {
                        throw new IllegalArgumentException();
                    }
                    parseDPiece(input, res, i, j, visited);
                } else {
                    parseSinglePiece(input, res, i, j, visited);
                }
            }
        }
        return res;
    }

    private static boolean borderInvalid(String[] newRow, int col) {
        return !newRow[0].equals(PointConstant.BORDER) || !newRow[col - 1].equals(PointConstant.BORDER);
    }

    private static void parseDPiece(String[][] input, String[][] res, int i, int j, boolean[][] visited) {
        res[i][j] = PointConstant.D_PIECE_LEFT_TOP;
        res[i][j + 1] = PointConstant.D_PIECE_RIGHT_TOP;
        res[i + 1][j] = PointConstant.D_PIECE_LEFT_BOT;
        res[i + 1][j + 1] = PointConstant.D_PIECE_RIGHT_BOT;
        visited[i][j] = true;
        visited[i][j + 1] = true;
        visited[i + 1][j] = true;
        visited[i + 1][j + 1] = true;
    }

    private static void parseHorPiece(String[][] input, String[][] res, int i, int j, boolean[][] visited) {
        res[i][j] = input[i][j];
        res[i][j + 1] = PointConstant.HOR_PIECE_RIGHT;
        visited[i][j] = true;
        visited[i][j + 1] = true;
    }

    private static void parseVerticalPiece(String[][] input, String[][] res, int i, int j, boolean[][] visited) {
        res[i][j] = input[i][j];
        res[i + 1][j] = Point.getBottomPieceFromTop(input[i][j]);
        visited[i][j] = true;
        visited[i + 1][j] = true;
    }

    private static boolean isValidDPiece(String[][] input, int i, int j) {
        if (input == null || input.length == 0 ||input[0].length == 0) return false;
        if (j >= input[0].length - 2 || i >= input.length - 2) return false;
        return true;
    }

    private static boolean isValidHorPiece(String[][] input, int i, int j) {
        if (input == null || input.length == 0 ||input[0].length == 0) return false;
        if (j >= input[0].length - 2) return false;
        return input[i][j].equals(input[i][j + 1]);
    }

    private static boolean isValidVerticalPiece(String[][] input, int i, int j) {
        if (i >= input.length - 2) return false;
        String bottomPiece = input[i + 1][j];
        return input[i][j].equals(bottomPiece);
    }

    private static boolean isDPiece(String piece) {
        return PointConstant.D_PIECE.equals(piece);
    }

    private static boolean isVerticalPiece(String piece) {
        return Point.belongsToVerticalPieceTop(piece);
    }

    private static boolean isHorizonPiece(String piece) {
        return PointConstant.HOR_PIECE_LEFT.equals(piece);
    }

    private static void parseSinglePiece(String[][] input, String[][] res, int i, int j, boolean[][] visited) {
        res[i][j] = input[i][j];
        visited[i][j] = true;
    }

    public static Point[] findExit(String[][] res) {
        Point[] arr = new Point[Maps.EXIT_SIZE];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (index == Maps.EXIT_SIZE)
                    break;
                if (!PointConstant.EXIT_CHARACTER.equals(res[i][j])) continue;
                if (i < 1)
                    throw new IllegalArgumentException();
                arr[index++] = new Point(j, i - 1);
            }
        }
        return arr;
    }
}
