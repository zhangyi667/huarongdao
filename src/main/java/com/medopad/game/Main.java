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
        Stack<Snapshot> stack = getSnapshots(PuzzleParser.parse(maps));
        printAllMoves(stack);
        System.out.println("In total " + (System.currentTimeMillis() - current) + " milli seconds");
    }

    private static void printAllMoves(Stack<Snapshot> stack) {
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
        Game game = new Game(maps);
        Snapshot snapshot = game.find();
        Stack<Snapshot> stack = new Stack<>();
        while (snapshot != null) {
            stack.add(snapshot);
            snapshot = snapshot.getParent();
        }
        return stack;
    }
}
