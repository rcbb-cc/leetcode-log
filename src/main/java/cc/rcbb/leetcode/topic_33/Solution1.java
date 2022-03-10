package cc.rcbb.leetcode.topic_33;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
class Solution1 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 前半部分
            if (nums[0] <= nums[mid]) {
                // 判断target是否在前半部分
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 后半部分
                // 判断target是否在后半部分
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        //输入：nums = [4,5,6,7,0,1,2], target = 0
        //输出：4
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        //输入：nums = [4,5,6,7,0,1,2], target = 3
        //输出：-1
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        //输入：nums = [1], target = 0
        //输出：-1
        System.out.println(solution.search(new int[]{1}, 0));
        //[5,1,3]
        //3
        System.out.println(solution.search(new int[]{5, 1, 3}, 3));
    }
}