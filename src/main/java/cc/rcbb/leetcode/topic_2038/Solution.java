package cc.rcbb.leetcode.topic_2038;

/**
 * 2038. 如果相邻两个颜色均相同则删除当前颜色
 * https://leetcode-cn.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
 */
class Solution {
    public boolean winnerOfGame(String colors) {
        char[] colorArray = colors.toCharArray();
        int a = 0;
        int b = 0;
        for (int i = 1; i < colorArray.length - 1; i++) {
            if (colorArray[i - 1] == 'A' && colorArray[i] == 'A' && colorArray[i + 1] == 'A') {
                a++;
            }
            if (colorArray[i - 1] == 'B' && colorArray[i] == 'B' && colorArray[i + 1] == 'B') {
                b++;
            }
        }
        return a > b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.winnerOfGame("AAABABB"));
        System.out.println(solution.winnerOfGame("AA"));
        System.out.println(solution.winnerOfGame("ABBBBBBBAAA"));
    }
}