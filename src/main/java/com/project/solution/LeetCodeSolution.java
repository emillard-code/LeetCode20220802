package com.project.solution;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

class LeetCodeSolution {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };

        System.out.println(method(matrix, 8));

    }

    public static int method(int[][] matrix, int k) {

        if (matrix == null || k <= 0) {
            throw new IllegalArgumentException("Input is invalid");
        }

        int n = matrix.length;

        if (k > n * n) {
            throw new NoSuchElementException("k is greater than number of elements in matrix");
        }

        if (k == 1) {
            return matrix[0][0];
        }

        if (k == n * n) {
            return matrix[n - 1][n - 1];
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (matrix[a[0]][a[1]] - matrix[b[0]][b[1]]));

        for (int i = 0; i < Math.min(n, k); i++) {
            queue.offer(new int[] { i, 0 });
        }

        while (k > 1) {
            int[] cur = queue.poll();
            if (cur[1] < n - 1) {
                cur[1]++;
                queue.offer(cur);
            }
            k--;
        }

        return matrix[queue.peek()[0]][queue.peek()[1]];
    }

}