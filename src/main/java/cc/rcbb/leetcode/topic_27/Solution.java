package cc.rcbb.leetcode.topic_27;

/**
 * 27. 移除元素
 */
public class Solution {
    /**
     * 双重for循环删除
     * 时间复杂度：O(n^2)
     */
    public int removeElement1(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; ) {
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

    /**
     * 快慢指针
     * 时间复杂度：O(n)
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (val != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] arr = new int[]{3, 2, 2, 3};
        int len = solution.removeElement(arr, 3);
        print(arr, len);

    }

    public static void print(int[] nums, int len) {
        System.out.println("len = " + len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
    }

}