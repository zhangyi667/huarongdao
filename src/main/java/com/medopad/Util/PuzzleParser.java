package com.medopad.Util;

import com.medopad.game.MapsBackup;
import com.medopad.game.Point;
import com.medopad.game.PointBackup;

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
                if (!PointBackup.LEGAL_CHARACTERS.contains(piece)) {
                    throw new IllegalArgumentException(String.format("%s is not a valid input", piece));
                }
                if (PointBackup.BORDER.equals(piece) || PointBackup.SPACE.equals(piece) || PointBackup.EXIT_CHARACTER.equals(piece)) {
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
        return !newRow[0].equals(PointBackup.BORDER) || !newRow[col - 1].equals(PointBackup.BORDER);
    }

    private static void parseDPiece(String[][] input, String[][] res, int i, int j, boolean[][] visited) {
        res[i][j] = PointBackup.D_PIECE_LEFT_TOP;
        res[i][j + 1] = PointBackup.D_PIECE_RIGHT_TOP;
        res[i + 1][j] = PointBackup.D_PIECE_LEFT_BOT;
        res[i + 1][j + 1] = PointBackup.D_PIECE_RIGHT_BOT;
        visited[i][j] = true;
        visited[i][j + 1] = true;
        visited[i + 1][j] = true;
        visited[i + 1][j + 1] = true;
    }

    private static void parseHorPiece(String[][] input, String[][] res, int i, int j, boolean[][] visited) {
        res[i][j] = input[i][j];
        res[i][j + 1] = PointBackup.HOR_PIECE_RIGHT;
        visited[i][j] = true;
        visited[i][j + 1] = true;
    }

    private static void parseVerticalPiece(String[][] input, String[][] res, int i, int j, boolean[][] visited) {
        res[i][j] = input[i][j];
        res[i + 1][j] = PointBackup.VERTICAL_PIECE.get(input[i][j]);
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
        return PointBackup.D_PIECE.equals(piece);
    }

    private static boolean isVerticalPiece(String piece) {
        return PointBackup.belongsToVerticalPieceTop(piece);
    }

    private static boolean isHorizonPiece(String piece) {
        return PointBackup.HOR_PIECE_LEFT.equals(piece);
    }

    private static void parseSinglePiece(String[][] input, String[][] res, int i, int j, boolean[][] visited) {
        res[i][j] = input[i][j];
        visited[i][j] = true;
    }

    public static Point[] findExit(String[][] res) {
        Point[] arr = new Point[MapsBackup.EXIT_SIZE];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (index == MapsBackup.EXIT_SIZE)
                    break;
                if (!PointBackup.EXIT_CHARACTER.equals(res[i][j])) continue;
                arr[index++] = new Point(i, j);
            }
        }
        return arr;
    }
}
