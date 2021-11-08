package cc.rcbb.leetcode.topic_34;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{leftSearch(nums, target), rightSearch(nums, target)};
    }

    public int leftSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public int rightSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        //输入: nums = [-1,0,3,5,9,12], target = 9 输出: 4
        //int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        //int target = 9;


        //输入: nums = [-1,0,3,5,9,12], target = 2 输出: -1 解释: 2 不存在 nums 中因此返回 -1
        //int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        //int target = 2;

        //int[] nums = new int[]{2, 5};
        //int target = 2;


        int[] nums = new int[]{0, 1, 2, 3, 3};
        int target = 3;

        int s = solution.rightSearch(nums, target);
        System.out.println(s);
    }
}