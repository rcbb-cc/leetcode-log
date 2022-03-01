package cc.rcbb.leetcode.topic_34;

import cc.rcbb.leetcode.common.RcbbPrinter;
/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1) {
            return new int[]{-1, -1};
        }
        return new int[]{leftSearch(nums, target), rightSearch(nums, target)};
    }

    private int leftSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //System.out.println("left=" + left + " right=" + right + " mid=" + mid);
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
            //System.out.println("left=" + left + " right=" + right);
        }
        if (left > nums.length - 1 || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int rightSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //System.out.println("left=" + left + " right=" + right + " mid=" + mid);
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
            //System.out.println("left=" + left + " right=" + right);
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        RcbbPrinter.print(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}