package cc.rcbb.leetcode.topic_769;

/**
 * 769. 最多能完成排序的块
 * https://leetcode.cn/problems/max-chunks-to-make-sorted/
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int m = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
            if (m == i) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    }
}