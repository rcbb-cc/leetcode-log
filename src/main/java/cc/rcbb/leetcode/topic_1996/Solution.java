package cc.rcbb.leetcode.topic_1996;

import java.util.Arrays;

/**
 * 1996. 游戏中弱角色的数量
 * https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/
 */
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        // 根据攻击力排序
        // 攻击力相同，让防御力低的排在后面
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int count = 0;
        int max = 0;
        for (int i = properties.length - 1; i >= 0; i--) {
            if (properties[i][1] < max) {
                count++;
            } else {
                max = properties[i][1];
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.numberOfWeakCharacters(new int[][]{{5, 6}, {6, 3}, {3, 6}}));
        // System.out.println(solution.numberOfWeakCharacters(new int[][]{{2, 2}, {3, 3}}));
        // System.out.println(solution.numberOfWeakCharacters(new int[][]{{1, 5}, {10, 4}, {4, 3}}));
        System.out.println(solution.numberOfWeakCharacters(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}}));
    }
}