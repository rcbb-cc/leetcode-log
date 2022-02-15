package cc.rcbb.leetcode.topic_540;

/**
 * 540. 有序数组中的单一元素
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0) {
                if (mid + 1 < n && nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[right];
    }

    public int singleNonDuplicate1(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i += 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(solution.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(solution.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 10, 11}));
        System.out.println(solution.singleNonDuplicate(new int[]{3}));
    }
}