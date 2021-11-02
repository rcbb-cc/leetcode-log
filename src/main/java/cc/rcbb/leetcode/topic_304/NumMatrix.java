package cc.rcbb.leetcode.topic_304;

class NumMatrix {

    int[][] arr = null;

    public NumMatrix(int[][] matrix) {
        arr = new int[matrix.length][matrix[0].length + 1];
        for (int j = 0; j < arr.length; j++) {
            for (int i = 1; i < arr[j].length; i++) {
                arr[j][i] = matrix[j][i - 1] + arr[j][i - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += this.arr[i][(col2 + 1)] - this.arr[i][col1];
        }
        return sum;
    }

    public static void main(String[] args) {
        //int[][] arr = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        int[][] arr = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        NumMatrix numMatrix = new NumMatrix(arr);
        int s1 = numMatrix.sumRegion(0, 0, 2, 2);
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