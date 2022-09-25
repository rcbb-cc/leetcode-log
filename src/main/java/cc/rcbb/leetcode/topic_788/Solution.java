package cc.rcbb.leetcode.topic_788;

/**
 * 788. 旋转数字
 * https://leetcode.cn/problems/rotated-digits/
 * <p>
 * 模拟
 */
class Solution {

    // 数中没有出现3,4,7
    // 数中至少出现一次 2 或 5 或 6 或 9
    // 对于0,1,8则没有要求
    static int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String num = String.valueOf(i);
            boolean valid = true;
            boolean diff = false;
            for (int j = 0; j < num.length(); j++) {
                char ch = num.charAt(j);
                if (check[ch - '0'] == -1) {
                    valid = false;
                } else if (check[ch - '0'] == 1) {
                    diff = true;
                }
            }
            if (valid && diff) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rotatedDigits(20));
    }

}