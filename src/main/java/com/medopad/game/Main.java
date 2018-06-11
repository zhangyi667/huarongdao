package com.medopad.game;

import com.medopad.Util.PuzzleParser;
import com.medopad.game.Snapshot.Snapshot;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        long current = System.currentTimeMillis();
        String[][] maps = new String[][] {
                new String[] {"X", "X", "X", "X", "X", "X"},
                new String[] {"X", "A", "D", "D", "H", "X"},
                new String[] {"X", "A", "D", "D", "H", "X"},
                new String[] {"X", "B", "E", "E", "I", "X"},
                new String[] {"X", "B", "F", "G", "I", "X"},
                new String[] {"X", "C", " ", " ", "J", "X"},
                new String[] {"X", "X", "Z", "Z", "X", "X"}
        };
        traverseAndPrint(maps);
        System.out.println("In total " + (System.currentTimeMillis() - current) + " milli seconds");
    }

    private static void traverseAndPrint(String[][] maps) {
        Stack<Snapshot> stack = getSnapshots(PuzzleParser.parse(maps));
        printAllMoves(stack);
    }

    private static void printAllMoves(Stack<Snapshot> stack) {
        if (null == stack || stack.isEmpty()) {
            System.out.println("There seems no answer for the puzzle :(");
            return;
        }
        int steps = 0;
        while (!stack.empty()) {
            Snapshot temp = stack.pop();
            System.out.println("----------------");
            temp.print();
            steps++;
        }
        System.out.println("total step: "+steps);
    }

    private static Stack<Snapshot> getSnapshots(String[][] maps) {
        Snapshot snapshot = new Game(maps).find();
        Stack<Snapshot> stack = new Stack<>();
        while (snapshot != null) {
            stack.add(snapshot);
            snapshot = snapshot.getParent();
        }
        return stack;
    }
}
