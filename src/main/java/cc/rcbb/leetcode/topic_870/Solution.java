package cc.rcbb.leetcode.topic_870;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 870. 优势洗牌
 * https://leetcode-cn.com/problems/advantage-shuffle/
 */
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] p1, int[] p2) -> {
            return p2[1] - p1[1];
        });
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        int left = 0;
        int right = n - 1;
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int i = pair[0];
            int maxVal = pair[1];
            if (maxVal < nums1[right]) {
                res[i] = nums1[right];
                right--;
            } else {
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：A = [2,7,11,15], B = [1,10,4,11]
        //输出：[2,11,7,15]
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
        //输入：A = [12,24,8,32], B = [13,25,32,11]
        //输出：[24,32,8,12]
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));

    }
}