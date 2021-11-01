package cc.rcbb.leetcode.topic_26;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = solution.removeDuplicates(arr);
        print(arr, len);

    }

    public static void print(int[] nums, int len) {
        System.out.println("len = " + len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; ) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                len = len - 1;
            } else {
                i++;
            }
        }
        return len;
    }

}