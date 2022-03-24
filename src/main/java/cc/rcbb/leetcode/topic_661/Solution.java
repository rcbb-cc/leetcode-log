package cc.rcbb.leetcode.topic_661;

/**
 * 661. 图片平滑器
 * https://leetcode-cn.com/problems/image-smoother/
 */
class Solution {

    int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                for (int[] d : dir) {
                    int di = d[0] + i;
                    int dj = d[1] + j;
                    if (di < 0 || di > m - 1 || dj < 0 || dj > n - 1) {
                        continue;
                    }
                    count++;
                    sum += img[di][dj];
                }
                res[i][j] = sum / count;
            }
        }
        return img;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.imageSmoother(new int[][]{{100,200,100},{200,50,200},{100,200,100}}));
    }
}