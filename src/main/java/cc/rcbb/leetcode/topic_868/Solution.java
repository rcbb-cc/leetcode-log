package cc.rcbb.leetcode.topic_868;

/**
 * 868. 二进制间距
 * https://leetcode-cn.com/problems/binary-gap/
 */
class Solution {
    public int binaryGap(int n) {
        int index = -1;
        int max = 0;
        for (int i = 0; n != 0; i++) {
            if ((n & 1) == 1) {
                if (index != -1) {
                    max = Math.max(max, i - index);
                }
                index = i;
            }
            n >>= 1;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.binaryGap(22));
        System.out.println(solution.binaryGap(8));
        System.out.println(solution.binaryGap(5));
    }
}