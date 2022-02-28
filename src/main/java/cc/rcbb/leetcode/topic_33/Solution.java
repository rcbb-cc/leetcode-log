package cc.rcbb.leetcode.topic_33;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > nums[i + 1]) {
                index = i;
                break;
            }
        }
        int r = search(nums, 0, index, target);
        if (r != -1) {
            return r;
        }
        if (index + 1 < n) {
            r = search(nums, index + 1, n - 1, target);
        }
        return r;
    }

    public int search(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：nums = [4,5,6,7,0,1,2], target = 0
        //输出：4
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        //输入：nums = [4,5,6,7,0,1,2], target = 3
        //输出：-1
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        //输入：nums = [1], target = 0
        //输出：-1
        System.out.println(solution.search(new int[]{1}, 0));
    }
}