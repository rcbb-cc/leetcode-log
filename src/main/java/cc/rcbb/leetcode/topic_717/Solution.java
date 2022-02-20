package cc.rcbb.leetcode.topic_717;

/**
 * 717. 1比特与2比特字符
 * https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int index = 0;
        while (index < n - 1) {
            if (bits[index] == 0) {
                index++;
            } else {
                index += 2;
            }
        }
        return index == n - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(solution.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
}