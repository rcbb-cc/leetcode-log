package cc.rcbb.leetcode.topic_27;

public class Solution {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len;) {
            if (nums[i] == val) {
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                len--;
            } else {
                i++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = solution.removeElement(arr, 1);
        print(arr, len);

    }

    public static void print(int[] nums, int len) {
        System.out.println("len = " + len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
    }

}