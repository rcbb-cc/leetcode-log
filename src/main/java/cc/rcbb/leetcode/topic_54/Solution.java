package cc.rcbb.leetcode.topic_54;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int upperBound = 0;
        int rightBound = col - 1;
        int leftBound = 0;
        int lowerBound = row - 1;
        while (result.size() < row * col) {
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    result.add(matrix[upperBound][i]);
                }
                upperBound++;
            }
            if (leftBound <= rightBound) {
                for (int i = upperBound; i <= lowerBound; i++) {
                    result.add(matrix[i][rightBound]);
                }
                rightBound--;
            }
            if (upperBound <= lowerBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    result.add(matrix[lowerBound][i]);
                }
                lowerBound--;
            }
            if (leftBound <= rightBound) {
                for (int i = lowerBound; i >= upperBound; i--) {
                    result.add(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }
        return result;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int upperBound = 0;
        int rightBound = col - 1;
        int leftBound = 0;
        int lowerBound = row - 1;
        System.out.println("upperBound=" + upperBound + " rightBound=" + rightBound + " leftBound=" + leftBound + " lowerBound=" + lowerBound);

        while (result.size() < row * col) {

            if (upperBound <= lowerBound) {
                // 从左往右
                for (int i = leftBound; i <= rightBound; i++) {
                    System.out.println("(" + upperBound + "," + i + ")");
                    result.add(matrix[upperBound][i]);
                }
                // 上边界下移
                upperBound++;
            }
            if (leftBound <= rightBound) {
                // 从上往下
                for (int i = upperBound; i <= lowerBound; i++) {
                    System.out.println("(" + i + "," + rightBound + ")");
                    result.add(matrix[i][rightBound]);
                }
                // 右边界左移
                rightBound--;
            }
            if (upperBound <= lowerBound) {
                // 从右往左
                for (int i = rightBound; i >= leftBound; i--) {
                    System.out.println("(" + lowerBound + "," + i + ")");
                    result.add(matrix[lowerBound][i]);
                }
                // 下边界上移
                lowerBound--;
            }
            if (leftBound <= rightBound) {
                // 从右往左
                for (int i = lowerBound; i >= upperBound; i--) {
                    System.out.println("(" + i + "," + leftBound + ")");
                    result.add(matrix[i][leftBound]);
                }
                // 左边距右移
                leftBound++;
            }
            System.out.println("upperBound=" + upperBound + " rightBound=" + rightBound + " leftBound=" + leftBound + " lowerBound=" + lowerBound);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        solution.spiralOrder1(matrix);
    }
}