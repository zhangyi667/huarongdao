package com.medopad.test;

import com.medopad.game.PointBackup;
import org.junit.Test;

public class TestPoints {

    @Test
    public void testGetVerticalPieces() {
        assert PointBackup.getBottomPieceFromTop("A").equals("O");
        assert PointBackup.getBottomPieceFromTop("B").equals("M");
        assert PointBackup.getBottomPieceFromTop("H").equals("K");
        assert PointBackup.getBottomPieceFromTop("I").equals("N");
        assert PointBackup.getTopPieceFromBottom("O").equals("A");
        assert PointBackup.getTopPieceFromBottom("M").equals("B");
        assert PointBackup.getTopPieceFromBottom("K").equals("H");
        assert PointBackup.getTopPieceFromBottom("N").equals("I");
    }


    @Test
    public void testIsSinglePiece() {
        assert PointBackup.isSinglePiece("C");
        assert PointBackup.isSinglePiece("F");
        assert PointBackup.isSinglePiece("G");
        assert PointBackup.isSinglePiece("J");
        assert !PointBackup.isSinglePiece("");
        assert !PointBackup.isSinglePiece(" ");
        assert !PointBackup.isSinglePiece("X");
        assert !PointBackup.isSinglePiece("Z");
        assert !PointBackup.isSinglePiece("A");
        assert !PointBackup.isSinglePiece("B");
        assert !PointBackup.isSinglePiece("H");
        assert !PointBackup.isSinglePiece("I");
        assert !PointBackup.isSinglePiece("O");
        assert !PointBackup.isSinglePiece("K");
        assert !PointBackup.isSinglePiece("M");
        assert !PointBackup.isSinglePiece("N");
        assert !PointBackup.isSinglePiece("E");
        assert !PointBackup.isSinglePiece("L");
    }

    @Test
    public void testBelongsToVerticalPiece() {
        assert PointBackup.belongsToVerticalPieceTop("A");
        assert PointBackup.belongsToVerticalPieceTop("B");
        assert PointBackup.belongsToVerticalPieceTop("H");
        assert PointBackup.belongsToVerticalPieceTop("I");
        assert !PointBackup.belongsToVerticalPieceTop("M");
        assert !PointBackup.belongsToVerticalPieceTop("N");
        assert !PointBackup.belongsToVerticalPieceTop("O");
        assert !PointBackup.belongsToVerticalPieceTop("K");
        assert !PointBackup.belongsToVerticalPieceTop("E");
        assert !PointBackup.belongsToVerticalPieceTop("L");
        assert !PointBackup.belongsToVerticalPieceTop("");
        assert !PointBackup.belongsToVerticalPieceTop(" ");
        assert PointBackup.belongsToVerticalPieceBottom("M");
        assert PointBackup.belongsToVerticalPieceBottom("N");
        assert PointBackup.belongsToVerticalPieceBottom("O");
        assert PointBackup.belongsToVerticalPieceBottom("K");
        assert !PointBackup.belongsToVerticalPieceBottom("A");
        assert !PointBackup.belongsToVerticalPieceBottom("B");
        assert !PointBackup.belongsToVerticalPieceBottom("H");
        assert !PointBackup.belongsToVerticalPieceBottom("I");

    }

    @Test
    public void testBelongsToHorizonPiece() {
        assert PointBackup.belongsToHorizonPiece("E");
        assert PointBackup.belongsToHorizonPiece("L");
        assert !PointBackup.belongsToHorizonPiece("A");
        assert !PointBackup.belongsToHorizonPiece("B");
        assert !PointBackup.belongsToHorizonPiece("H");
        assert !PointBackup.belongsToHorizonPiece("I");
        assert !PointBackup.belongsToHorizonPiece("O");
        assert !PointBackup.belongsToHorizonPiece("K");
        assert !PointBackup.belongsToHorizonPiece("M");
        assert !PointBackup.belongsToHorizonPiece("N");
        assert !PointBackup.belongsToHorizonPiece("");
        assert !PointBackup.belongsToHorizonPiece(" ");
    }


    @Test
    public void testBelongsToDPiece() {
        char a = 'A';
        while (a <= 'Z') {
            assert !PointBackup.belongsToDPiece(Character.toString(a));
            a++;
        }
        assert PointBackup.belongsToDPiece("6");
        assert PointBackup.belongsToDPiece("7");
        assert PointBackup.belongsToDPiece("8");
        assert PointBackup.belongsToDPiece("9");
        assert !PointBackup.belongsToDPiece("");
        assert !PointBackup.belongsToDPiece(" ");
    }


}
