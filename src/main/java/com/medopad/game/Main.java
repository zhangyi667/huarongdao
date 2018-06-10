package com.medopad.game;

import com.medopad.game.Snapshot.Snapshot;

import java.util.*;

public class Main {
    public static void main(String args[])
    {

        long current = System.currentTimeMillis();

        int maps[] = {
                4, 6, 7, 4,
                5, 8, 9, 5,
                1, 2, 3, 1,
                4, 1, 1, 4,
                5, 0, 0, 5
        };

        /**
         *
         XXXXXX
         XADDHX
         XADDHX
         XBEEIX
         XBFGIX
         XC  JX
         XXZZXX
         *
         * **/

        Stack<Snapshot> stack = getSnapshots(maps);

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

    private static Stack<Snapshot> getSnapshots(int[] maps) {
        Game game = new Game(maps, 5, 4, new Point(1, 4), new Point(2, 4));
        Snapshot snapshot = game.find();
        Stack<Snapshot> stack = new Stack<>();
        while (snapshot != null) {
            stack.add(snapshot);
            snapshot = snapshot.getParent();
        }
        return stack;
    }
}
