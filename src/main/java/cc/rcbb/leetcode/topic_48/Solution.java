package cc.rcbb.leetcode.topic_48;


/**
 * 48. 旋转图像
 * https://leetcode-cn.com/problems/rotate-image/
 */
class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 先沿对角线镜像对称二维矩阵
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                //System.out.println("(" + i + "," + j + ")");
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 反转二维矩阵的每一行
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col - j - 1];
                matrix[i][col - j - 1] = temp;
            }
        }
    }

    /*for (int i = 0; i < row; i++) {
        System.out.println(Arrays.toString(matrix[i]));
    }
        System.out.println();*/
    // 反转一维数组
    void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (j > i) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        solution.rotate(matrix);
    }
}