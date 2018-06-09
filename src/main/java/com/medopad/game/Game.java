package com.medopad.game;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class Game {
    protected int maps[];
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

    public Snapshot find() {
        Snapshot node;
        String key;
        LinkedList<Snapshot> nexts;

        root = new Snapshot(maps, rows, cols);
        queue = new LinkedList<>();
        queue.add(root);
        key = root.getHashKey();
        collections.add(key);

        while (!queue.isEmpty()) {
            node = queue.poll();
            if(null == node) continue;
            nexts = node.listAllPossibleNextMove();

            for (Snapshot next : nexts) {
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
