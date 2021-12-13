package cc.rcbb.leetcode.topic_72;

import java.util.Arrays;

/**
 * 72. 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 */
class Solution1 {

    int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    public int f(String word1, int i, String word2, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = f(word1, i - 1, word2, j - 1);
        } else {

            memo[i][j] = Math.min(
                    // 插入
                    f(word1, i, word2, j - 1) + 1,
                    Math.min(
                            // 删除
                            f(word1, i - 1, word2, j) + 1,
                            // 替换
                            f(word1, i - 1, word2, j - 1) + 1)
            );
        }
        return memo[i][j];
    }

    public static void main(String[] args) {

        Solution1 solution = new Solution1();
        /*输入：word1 = "horse", word2 = "ros"
        输出：3
        解释：
        horse -> rorse (将 'h' 替换为 'r')
        rorse -> rose (删除 'r')
        rose -> ros (删除 'e')*/
        System.out.println(solution.minDistance("horse", "ros"));
    }
}