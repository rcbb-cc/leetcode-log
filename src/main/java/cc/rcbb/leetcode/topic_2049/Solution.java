package cc.rcbb.leetcode.topic_2049;

import java.util.ArrayList;
import java.util.List;

/**
 * 2049. 统计最高分的节点数目
 * https://leetcode-cn.com/problems/count-nodes-with-the-highest-score/
 */
class Solution {

    long maxScore = 0;
    int count = 0;
    int n;
    List<Integer>[] children;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int p = parents[i];
            if (p != -1) {
                children[p].add(i);
            }
        }
        dfs(0);
        return count;
    }

    private int dfs(int node) {
        long score = 1;
        int nodeCount = 1;
        for (int c : children[node]) {
            int t = dfs(c);
            score *= t;
            nodeCount += t;
        }
        if (node != 0) {
            score *= (n - nodeCount);
        }
        if (score == maxScore) {
            count++;
        } else if (score > maxScore) {
            maxScore = score;
            count = 1;
        }
        return nodeCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：parents = [-1,2,0,2,0]
        //输出：3
        //解释：
        //- 节点 0 的分数为：3 * 1 = 3
        //        - 节点 1 的分数为：4 = 4
        //        - 节点 2 的分数为：1 * 1 * 2 = 2
        //        - 节点 3 的分数为：4 = 4
        //        - 节点 4 的分数为：4 = 4
        //最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
        //System.out.println(solution.countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0}));
        System.out.println(solution.countHighestScoreNodes(new int[]{-1, 2, 0}));
    }
}