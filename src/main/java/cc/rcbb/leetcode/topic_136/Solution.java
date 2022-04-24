package cc.rcbb.leetcode.topic_136;

/**
 * 136. 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 * <p>
 * 任何数和 0 做异或运算，结果仍然是原来的数，即 a^0=a
 * 任何数和其自身做异或运算，结果是 0，即 a^a=0。
 * 异或运算满足交换律和结合律，即 a^b^a=b^a^a=b^(a^a)=b^0==b。
 */
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{2, 2, 1}));
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}