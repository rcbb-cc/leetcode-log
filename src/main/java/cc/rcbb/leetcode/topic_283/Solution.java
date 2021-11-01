package cc.rcbb.leetcode.topic_283;

public class Solution {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; ) {
            if (nums[i] == 0) {
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[len - 1] = 0;
                len--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        solution.moveZeroes(arr);
        print(arr);

    }

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}