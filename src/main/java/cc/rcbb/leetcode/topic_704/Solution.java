package cc.rcbb.leetcode.topic_704;

class Solution {
    /**
     * 暴力
     * 时间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result = i;
            }
        }
        return result;
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
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


        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 2;

        int s = solution.search(nums, target);
        System.out.println(s);
    }
}