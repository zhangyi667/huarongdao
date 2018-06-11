package com.medopad.test;

import com.medopad.game.Maps;
import org.junit.Test;

public class TestMaps {
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
        Maps maps = new Maps(expectedOutput);
        maps.print();
    }






}
