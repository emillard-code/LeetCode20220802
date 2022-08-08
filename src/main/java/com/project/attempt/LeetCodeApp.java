package com.project.attempt;

import java.util.ArrayList;
import java.util.Collections;

public class LeetCodeApp {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
            {1,5,9},
            {10,11,13},
            {12,13,15}
        };

        System.out.println(method(matrix, 8));

    }

    public static int method(int[][] matrix, int target) {

        ArrayList<Integer> newMatrix = new ArrayList<Integer>();

        for (int[] numberArr : matrix) {
            for (int number : numberArr) {
                newMatrix.add(number);
            }
        }

        Collections.sort(newMatrix);

        return newMatrix.get(target - 1);

    }

}