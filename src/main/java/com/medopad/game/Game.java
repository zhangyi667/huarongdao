package com.medopad.game;

import com.medopad.Util.PuzzleParser;
import com.medopad.game.Snapshot.Snapshot;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Game {
    private String[][] mapsBackup;
    private int rows;
    private int cols;

    private Snapshot root;
    private Queue<Snapshot> queue;

    private HashSet<String> collections = new HashSet<>();

    private Point endPositionLeft;
    private Point endPositionRight;

    Game(String[][] maps) {
        this.mapsBackup = maps;
        this.rows = maps.length;
        this.cols = maps[0].length;
        Point[] arr = PuzzleParser.findExit(maps);
        this.endPositionLeft = arr[0];
        this.endPositionRight = arr[1];
    }

    Snapshot find() {
        Snapshot node;
        String key;
        List<Snapshot> allNextMoves;
        root = new Snapshot(mapsBackup);
        queue = new LinkedList<>();
        queue.add(root);
        key = root.getHashKey();
        collections.add(key);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if(null == node) continue;
            allNextMoves = node.listAllPossibleNextMove();
            for (Snapshot next : allNextMoves) {
                key = next.getHashKey();
                if (collections.contains(key)) {
                    continue;
                }
                collections.add(key);
                node.add(next);
                queue.offer(next);
                if (next.isEnd(endPositionLeft, endPositionRight)) {
                    return next;
                }
            }
        }
        return null;
    }
}
