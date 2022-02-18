package cc.rcbb.leetcode.topic_1791;

/**
 * 1791. 找出星型图的中心节点
 * https://leetcode-cn.com/problems/find-center-of-star-graph/
 */
class Solution {
    public int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];
        int c = edges[1][0];
        int d = edges[1][1];
        if (a == c || a == d) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
        System.out.println(solution.findCenter(new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}}));
    }
}