package cc.rcbb.leetcode.topic_1725;

/**
 * 1725. 可以形成最大正方形的矩形数目
 * https://leetcode-cn.com/problems/number-of-rectangles-that-can-form-the-largest-square/
 */
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        int count = 0;
        for (int[] arr : rectangles) {
            int cur = Math.min(arr[0], arr[1]);
            if (cur == max) {
                count++;
            } else if (cur > max) {
                max = cur;
                count = 1;
            }
        }
        return count;
    }

    public int countGoodRectangles1(int[][] rectangles) {
        int[] lenArray = new int[rectangles.length];
        int max = 0;
        for (int i = 0; i < rectangles.length; i++) {
            lenArray[i] = Math.min(rectangles[i][0], rectangles[i][1]);
            if (lenArray[i] > max) {
                max = lenArray[i];
            }
        }
        int count = 0;
        for (int i = 0; i < lenArray.length; i++) {
            if (lenArray[i] >= max) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countGoodRectangles(new int[][]{{5, 8}, {3, 9}, {5, 12}, {16, 5}}));
        System.out.println(solution.countGoodRectangles(new int[][]{{2, 3}, {3, 7}, {4, 3}, {3, 7}}));
    }
}