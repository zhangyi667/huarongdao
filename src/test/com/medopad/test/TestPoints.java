package com.medopad.test;

import com.medopad.game.PointConstant;
import org.junit.Test;

public class TestPoints {

    @Test
    public void testGetVerticalPieces() {
        assert PointConstant.Point.getBottomPieceFromTop("A").equals("O");
        assert PointConstant.Point.getBottomPieceFromTop("B").equals("M");
        assert PointConstant.Point.getBottomPieceFromTop("H").equals("K");
        assert PointConstant.Point.getBottomPieceFromTop("I").equals("N");
        assert PointConstant.Point.getTopPieceFromBottom("O").equals("A");
        assert PointConstant.Point.getTopPieceFromBottom("M").equals("B");
        assert PointConstant.Point.getTopPieceFromBottom("K").equals("H");
        assert PointConstant.Point.getTopPieceFromBottom("N").equals("I");
    }


    @Test
    public void testIsSinglePiece() {
        assert PointConstant.Point.isSinglePiece("C");
        assert PointConstant.Point.isSinglePiece("F");
        assert PointConstant.Point.isSinglePiece("G");
        assert PointConstant.Point.isSinglePiece("J");
        assert !PointConstant.Point.isSinglePiece("");
        assert !PointConstant.Point.isSinglePiece(" ");
        assert !PointConstant.Point.isSinglePiece("X");
        assert !PointConstant.Point.isSinglePiece("Z");
        assert !PointConstant.Point.isSinglePiece("A");
        assert !PointConstant.Point.isSinglePiece("B");
        assert !PointConstant.Point.isSinglePiece("H");
        assert !PointConstant.Point.isSinglePiece("I");
        assert !PointConstant.Point.isSinglePiece("O");
        assert !PointConstant.Point.isSinglePiece("K");
        assert !PointConstant.Point.isSinglePiece("M");
        assert !PointConstant.Point.isSinglePiece("N");
        assert !PointConstant.Point.isSinglePiece("E");
        assert !PointConstant.Point.isSinglePiece("L");
    }

    @Test
    public void testBelongsToVerticalPiece() {
        assert PointConstant.Point.belongsToVerticalPieceTop("A");
        assert PointConstant.Point.belongsToVerticalPieceTop("B");
        assert PointConstant.Point.belongsToVerticalPieceTop("H");
        assert PointConstant.Point.belongsToVerticalPieceTop("I");
        assert !PointConstant.Point.belongsToVerticalPieceTop("M");
        assert !PointConstant.Point.belongsToVerticalPieceTop("N");
        assert !PointConstant.Point.belongsToVerticalPieceTop("O");
        assert !PointConstant.Point.belongsToVerticalPieceTop("K");
        assert !PointConstant.Point.belongsToVerticalPieceTop("E");
        assert !PointConstant.Point.belongsToVerticalPieceTop("L");
        assert !PointConstant.Point.belongsToVerticalPieceTop("");
        assert !PointConstant.Point.belongsToVerticalPieceTop(" ");
        assert PointConstant.Point.belongsToVerticalPieceBottom("M");
        assert PointConstant.Point.belongsToVerticalPieceBottom("N");
        assert PointConstant.Point.belongsToVerticalPieceBottom("O");
        assert PointConstant.Point.belongsToVerticalPieceBottom("K");
        assert !PointConstant.Point.belongsToVerticalPieceBottom("A");
        assert !PointConstant.Point.belongsToVerticalPieceBottom("B");
        assert !PointConstant.Point.belongsToVerticalPieceBottom("H");
        assert !PointConstant.Point.belongsToVerticalPieceBottom("I");

    }

    @Test
    public void testBelongsToHorizonPiece() {
        assert PointConstant.Point.belongsToHorizonPiece("E");
        assert PointConstant.Point.belongsToHorizonPiece("L");
        assert !PointConstant.Point.belongsToHorizonPiece("A");
        assert !PointConstant.Point.belongsToHorizonPiece("B");
        assert !PointConstant.Point.belongsToHorizonPiece("H");
        assert !PointConstant.Point.belongsToHorizonPiece("I");
        assert !PointConstant.Point.belongsToHorizonPiece("O");
        assert !PointConstant.Point.belongsToHorizonPiece("K");
        assert !PointConstant.Point.belongsToHorizonPiece("M");
        assert !PointConstant.Point.belongsToHorizonPiece("N");
        assert !PointConstant.Point.belongsToHorizonPiece("");
        assert !PointConstant.Point.belongsToHorizonPiece(" ");
    }


    @Test
    public void testBelongsToDPiece() {
        char a = 'A';
        while (a <= 'Z') {
            assert !PointConstant.Point.belongsToDPiece(Character.toString(a));
            a++;
        }
        assert PointConstant.Point.belongsToDPiece("6");
        assert PointConstant.Point.belongsToDPiece("7");
        assert PointConstant.Point.belongsToDPiece("8");
        assert PointConstant.Point.belongsToDPiece("9");
        assert !PointConstant.Point.belongsToDPiece("");
        assert !PointConstant.Point.belongsToDPiece(" ");
    }


}
