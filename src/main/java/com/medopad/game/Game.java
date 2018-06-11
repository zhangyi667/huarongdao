package com.medopad.game;

import com.medopad.Util.PuzzleParser;
import com.medopad.game.Snapshot.Snapshot;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Game {
    protected int maps[];
    protected String[][] mapsBackup;
    protected int rows;
    protected int cols;

    protected Snapshot root;
    Queue<Snapshot> queue;

    HashSet<String> collections = new HashSet<>();

    protected Point endPosition1;
    protected Point endPosition2;

    public Game(int maps[], int rows, int cols, Point endPosition1, Point endPosition2) {
        this.maps = maps;
        this.rows = rows;
        this.cols = cols;

        this.endPosition1 = endPosition1;
        this.endPosition2 = endPosition2;

    }
    public Game(String[][] maps) {
        this.mapsBackup = maps;
        this.rows = maps.length;
        this.cols = maps[0].length;
        Point[] arr = PuzzleParser.findExit(maps);
        this.endPosition1 = arr[0];
        this.endPosition2 = arr[1];
    }

    public Snapshot find() {
        Snapshot node;
        String key;
        List<Snapshot> nextMoves;
        root = new Snapshot(maps, rows, cols);
        queue = new LinkedList<>();
        queue.add(root);
        key = root.getHashKey();
        collections.add(key);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if(null == node) continue;
            nextMoves = node.listAllPossibleNextMove();
            for (Snapshot next : nextMoves) {
                key = next.getHashKey();
                if (collections.contains(key)) {
                    continue;
                }
                collections.add(key);

                node.add(next);
                queue.offer(next);

                if (next.isEnd(endPosition1, endPosition2)) {
                    return next;
                }
            }

        }


        return null;
    }
}
