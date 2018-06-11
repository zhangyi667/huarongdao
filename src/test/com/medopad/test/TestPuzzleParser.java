package com.medopad.test;

import com.medopad.Util.PuzzleParser;
import com.medopad.game.Maps;
import com.medopad.game.Point;
import org.junit.Test;

import java.util.Arrays;

public class TestPuzzleParser {
    private String[][] validInput = new String[][] {
            new String[] {"X", "X", "X", "X", "X", "X"},
            new String[] {"X", "A", "D", "D", "H", "X"},
            new String[] {"X", "A", "D", "D", "H", "X"},
            new String[] {"X", "B", "E", "E", "I", "X"},
            new String[] {"X", "B", "F", "G", "I", "X"},
            new String[] {"X", "C", " ", " ", "J", "X"},
            new String[] {"X", "X", "Z", "Z", "X", "X"}
    };

    private String[][] inValidInput = new String[][] {
            new String[] {"X", "X", "X", "X", "X", "X"},
            new String[] {"X", "A", "D", "D", "H", "C"},// here, no border
            new String[] {"X", "A", "D", "D", "H", "X"},
            new String[] {"X", "B", "E", "E", "I", "X"},
            new String[] {"X", "B", "F", "G", "I", "X"},
            new String[] {"X", "C", " ", " ", "J", "X"},
            new String[] {"X", "X", "Z", "Z", "X", "X"}
    };

    private String[][] inValidInput2 = new String[][] {
            new String[] {"X", "X", "X", "X", "X", "X"},
            new String[] {"X", "A", "D", "D", "H"},// here, border lack
            new String[] {"X", "A", "D", "D", "H", "X"},
            new String[] {"X", "B", "E", "E", "I", "X"},
            new String[] {"X", "B", "F", "G", "I", "X"},
            new String[] {"X", "C", " ", " ", "J", "X"},
            new String[] {"X", "X", "Z", "Z", "X", "X"}
    };

    private String[][] expectedOutput = new String[][] {
            new String[] {"X", "X", "X", "X", "X", "X"},
            new String[] {"X", "A", "6", "7", "H", "X"},
            new String[] {"X", "O", "8", "9", "K", "X"},
            new String[] {"X", "B", "E", "L", "I", "X"},
            new String[] {"X", "M", "F", "G", "N", "X"},
            new String[] {"X", "C", " ", " ", "J", "X"},
            new String[] {"X", "X", "Z", "Z", "X", "X"}
    };

    @Test(expected = IllegalArgumentException.class)
    public void thrownExceptionForNullParams() {
        String[][] res = PuzzleParser.parse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void thrownExceptionForInvalidParams() {
        String[][] res = PuzzleParser.parse(inValidInput);
    }

   @Test(expected = IllegalArgumentException.class)
    public void thrownExceptionForInvalidParams2() {
        String[][] res = PuzzleParser.parse(inValidInput2);
    }

    @Test
    public void testParser() {
        String[][] res = PuzzleParser.parse(validInput);
        assert res.length == expectedOutput.length;
        for (int i = 0; i < res.length; i++) {
            assert Arrays.equals(res[i], expectedOutput[i]);
        }
    }


    @Test
    public void testFindExit() {
        String[][] res = PuzzleParser.parse(validInput);
        Point[] arr = PuzzleParser.findExit(res);
        assert arr.length == Maps.EXIT_SIZE;
        assert arr[0].y == 5 && arr[0].x == 2;
        assert arr[1].y == 5 && arr[1].x == 3;
    }




}
