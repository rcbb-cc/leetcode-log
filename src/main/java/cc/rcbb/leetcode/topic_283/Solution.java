package cc.rcbb.leetcode.topic_283;

/**
 * 283. 移动零
 */
public class Solution {

    /**
     * 双重for循环移动元素0
     * 时间复杂度：O(n^2)
     */
    public void moveZeroes1(int[] nums) {
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

    /**
     * 快慢指针
     * 分析：时间复杂度 O(n)
     */
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int len = nums.length;
        int fast = 0;
        int slow = 0;
        while (fast < len) {
            if (0 != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < fast) {
            nums[slow] = 0;
            slow++;
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