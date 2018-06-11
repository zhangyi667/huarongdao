package com.medopad.test;

import com.medopad.game.Point;
import org.junit.Test;

public class TestPoints {

    @Test
    public void testGetVerticalPieces() {
        assert Point.getBottomPieceFromTop("A").equals("O");
        assert Point.getBottomPieceFromTop("B").equals("M");
        assert Point.getBottomPieceFromTop("H").equals("K");
        assert Point.getBottomPieceFromTop("I").equals("N");
        assert Point.getTopPieceFromBottom("O").equals("A");
        assert Point.getTopPieceFromBottom("M").equals("B");
        assert Point.getTopPieceFromBottom("K").equals("H");
        assert Point.getTopPieceFromBottom("N").equals("I");
    }


    @Test
    public void testIsSinglePiece() {
        assert Point.isSinglePiece("C");
        assert Point.isSinglePiece("F");
        assert Point.isSinglePiece("G");
        assert Point.isSinglePiece("J");
        assert !Point.isSinglePiece("");
        assert !Point.isSinglePiece(" ");
        assert !Point.isSinglePiece("X");
        assert !Point.isSinglePiece("Z");
        assert !Point.isSinglePiece("A");
        assert !Point.isSinglePiece("B");
        assert !Point.isSinglePiece("H");
        assert !Point.isSinglePiece("I");
        assert !Point.isSinglePiece("O");
        assert !Point.isSinglePiece("K");
        assert !Point.isSinglePiece("M");
        assert !Point.isSinglePiece("N");
        assert !Point.isSinglePiece("E");
        assert !Point.isSinglePiece("L");
    }

    @Test
    public void testBelongsToVerticalPiece() {
        assert Point.belongsToVerticalPieceTop("A");
        assert Point.belongsToVerticalPieceTop("B");
        assert Point.belongsToVerticalPieceTop("H");
        assert Point.belongsToVerticalPieceTop("I");
        assert !Point.belongsToVerticalPieceTop("M");
        assert !Point.belongsToVerticalPieceTop("N");
        assert !Point.belongsToVerticalPieceTop("O");
        assert !Point.belongsToVerticalPieceTop("K");
        assert !Point.belongsToVerticalPieceTop("E");
        assert !Point.belongsToVerticalPieceTop("L");
        assert !Point.belongsToVerticalPieceTop("");
        assert !Point.belongsToVerticalPieceTop(" ");
        assert Point.belongsToVerticalPieceBottom("M");
        assert Point.belongsToVerticalPieceBottom("N");
        assert Point.belongsToVerticalPieceBottom("O");
        assert Point.belongsToVerticalPieceBottom("K");
        assert !Point.belongsToVerticalPieceBottom("A");
        assert !Point.belongsToVerticalPieceBottom("B");
        assert !Point.belongsToVerticalPieceBottom("H");
        assert !Point.belongsToVerticalPieceBottom("I");

    }

    @Test
    public void testBelongsToHorizonPiece() {
        assert Point.belongsToHorizonPiece("E");
        assert Point.belongsToHorizonPiece("L");
        assert !Point.belongsToHorizonPiece("A");
        assert !Point.belongsToHorizonPiece("B");
        assert !Point.belongsToHorizonPiece("H");
        assert !Point.belongsToHorizonPiece("I");
        assert !Point.belongsToHorizonPiece("O");
        assert !Point.belongsToHorizonPiece("K");
        assert !Point.belongsToHorizonPiece("M");
        assert !Point.belongsToHorizonPiece("N");
        assert !Point.belongsToHorizonPiece("");
        assert !Point.belongsToHorizonPiece(" ");
    }


    @Test
    public void testBelongsToDPiece() {
        char a = 'A';
        while (a <= 'Z') {
            assert !Point.belongsToDPiece(Character.toString(a));
            a++;
        }
        assert Point.belongsToDPiece("6");
        assert Point.belongsToDPiece("7");
        assert Point.belongsToDPiece("8");
        assert Point.belongsToDPiece("9");
        assert !Point.belongsToDPiece("");
        assert !Point.belongsToDPiece(" ");
    }


}
