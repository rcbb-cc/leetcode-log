package cc.rcbb.leetcode.topic_26;

/**
 * 26. 删除有序数组中的重复项
 */
public class Solution {

    /**
     * 双重for循环遍历删除
     * 时间复杂度： O(n^2)
     */
    public int removeDuplicates1(int[] nums) {
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

    /**
     * 快慢指针
     * 当快指针的内容与慢指针的内容不一样时，将不一样的值记录到下一个慢指针的位置上。
     * 分析：时间复杂度 O(n)
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }


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


}