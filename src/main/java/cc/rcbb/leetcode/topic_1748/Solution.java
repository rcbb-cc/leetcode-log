package cc.rcbb.leetcode.topic_1748;

/**
 * 1748. 唯一元素的和
 * https://leetcode-cn.com/problems/sum-of-unique-elements/
 */
class Solution {
    public int sumOfUnique(int[] nums) {
        int n = 101;
        int[] arr = new int[n];
        for (int i = 0; i < n && i < nums.length; i++) {
            arr[nums[i]]++;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumOfUnique(new int[]{1, 2, 3, 2}));
        System.out.println(solution.sumOfUnique(new int[]{1, 1, 1, 1, 1}));
        System.out.println(solution.sumOfUnique(new int[]{1, 2, 3, 4, 5}));

    }
}