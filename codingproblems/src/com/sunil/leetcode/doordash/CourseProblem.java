package com.sunil.leetcode.doordash;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi]
 * this means you must take the course bi before the course ai.
 *
 * Given the total number of courses numCourses and a list of the prerequisite pairs,
 * return the ordering of courses you should take to finish all courses.
 *
 * If there are many valid answers, return any of them. If it is impossible to finish all courses,
 * return an empty array.
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0.
 * So the correct course order is [0,1].
 *
 * Example 2:
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished
 * both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 *
 * Example 3:
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 **/

public class CourseProblem {
    private static List<Integer>[] g;
    private static int[] status;
    private static int[] result;
    private static int index;
    private static final int UNVISITED = 0, EXPLORING = 1, DONE = 2;

    public static void main(String[] args) {
        int numOfCources = 2;
        int[][] prerequisites = {{1, 0}};

        int[] result = findOrder(numOfCources, prerequisites);

        for (int value : result)
            System.out.println(value + " ");
    }

    private static int[] findOrder(int n, int[][] pq) {
        index = n;
        status = new int[n];
        result = new int[n];
        g = new ArrayList[n];

        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();

        for (int[] edge: pq) {
            int i = edge[0], j = edge[1];
            g[j].add(i);
        }
        return hasCycle(n) ? new int[]{} : result;
    }

    private static boolean hasCycle(int n) {
        for (int i = 0; i < n; i++) {
            if (UNVISITED == status[i] && dfs(i))
                return true;
        }
        return false;
    }

    private static boolean dfs(int node) {
        if(status[node] == EXPLORING)
            return true;
        if(status[node] == DONE)
            return false;

        status[node] = EXPLORING;
        for (int neighbour: g[node]) {
            if (dfs(neighbour))
                return true;
        }

        status[node] = DONE;
        result[--index] = node;
        return false;
    }
}
