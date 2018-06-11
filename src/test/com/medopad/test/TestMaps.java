package com.medopad.test;

import com.medopad.Util.PuzzleParser;
import com.medopad.game.MapsBackup;
import com.medopad.game.Point;
import org.junit.Test;

import java.util.Arrays;

public class TestMaps {
    private String[][] validInput = new String[][] {
            new String[] {"X", "X", "X", "X", "X", "X"},
            new String[] {"X", "A", "D", "D", "H", "X"},
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


    @Test
    public void testPrintHelper() {
        MapsBackup maps = new MapsBackup(expectedOutput);
        maps.print();
    }






}
