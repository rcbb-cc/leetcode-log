package cc.rcbb.leetcode.topic_304;

public class NumMatrix1 {

    int[][] matrix = null;

    public NumMatrix1(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    //System.out.println("("+i + "," + j + ") " + matrix[i][j]);


    public static void main(String[] args) {
        int[][] arr = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix1 numMatrix = new NumMatrix1(arr);
        int s1 = numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(s1);
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
