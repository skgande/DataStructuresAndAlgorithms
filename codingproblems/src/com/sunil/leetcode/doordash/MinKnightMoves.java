package com.sunil.leetcode.doordash;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
 *
 * A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction,
 * then one square in an orthogonal direction.
 *
 * Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.
 *
 * Example 1:
 * Input: x = 2, y = 1
 * Output: 1
 * Explanation: [0, 0] → [2, 1]
 *
 * Example 2:
 * Input: x = 5, y = 5
 * Output: 4
 * Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 */
class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MinKnightMoves {
    public static void main(String[] args) {
        int x = 2, y = 1;
        System.out.print(" Min number of moves required to reach [" + x + ", "+ y +"] is " + minKnightMoves(x, y) + "\n");

        x = 5; y = 5;
        System.out.print(" Min number of moves required to reach [" + x + ", "+ y +"] is " + minKnightMoves(x, y));
    }

    private static int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int[] xDir = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] yDir = {-1, 1, -2, 2, -2, 2, -1, 1};

        int moves = 0;
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(0,0));

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        while (!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                Coordinate p = q.remove();
                if(p.x == x && p.y == y) {
                    return moves;
                }
                for (int j = 0; j < xDir.length; j++) {
                    int newPx = p.x + xDir[j];
                    int newPy = p.y + yDir[j];

                    String s = newPx + "," + newPy;
                    if(!visited.contains(s) && newPx > -2 &&newPy > -2)  {
                        q.add(new Coordinate(newPx, newPy));
                        visited.add(s);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
