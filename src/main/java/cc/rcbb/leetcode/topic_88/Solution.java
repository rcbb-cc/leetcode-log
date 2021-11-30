package cc.rcbb.leetcode.topic_88;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
class Solution {
    /**
     * 使用方法，合并后排序
     * 时间复杂度：O((m+n)log(m+n))
     * 空间复杂度：O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        RcbbPrinter.print(nums1);
    }

    /**
     * 双指针，从前往后
     * 两个数组按顺序比较，放入新的数组
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(m)
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int left = 0;
        int right = 0;
        int count = 0;
        while (left < m || right < n) {
            if (left < m && right >= n) {
                nums1[count] = nums1_copy[left];
                left++;
            }
            if (left >= m && right < n) {
                nums1[count] = nums2[right];
                right++;
            }
            if (left < m && right < n) {
                if (nums1_copy[left] < nums2[right]) {
                    nums1[count] = nums1_copy[left];
                    left++;
                } else if (nums1_copy[left] >= nums2[right]) {
                    nums1[count] = nums2[right];
                    right++;
                }
            }
            count++;
        }
        RcbbPrinter.print(nums1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] num2 = new int[]{2, 5, 6};
        int n = 3;

        //输入：nums1 = [0], m = 0, nums2 = [1], n = 1
        //输出：[1]
        //解释：需要合并的数组是 [] 和 [1] 。
        //合并结果是 [1] 。
        //注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
        //int[] num1 = new int[]{0};
        //int m = 0;
        //int[] num2 = new int[]{1};
        //int n = 1;
        solution.merge(num1, m, num2, n);
        solution.merge1(num1, m, num2, n);
    }
}