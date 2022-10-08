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
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);

        int[] res = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                res[idx2[left]] = nums1[idx1[i]];
                left++;
            } else {
                // 田忌赛马，使用最小的对上最大的
                res[idx2[right]] = nums1[idx1[i]];
                right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：A = [2,7,11,15], B = [1,10,4,11]
        //输出：[2,11,7,15]
        // System.out.println(Arrays.toString(solution.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
        //输入：A = [12,24,8,32], B = [13,25,32,11]
        //输出：[24,32,8,12]
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
    }
}