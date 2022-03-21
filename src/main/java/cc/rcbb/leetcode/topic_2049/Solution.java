package cc.rcbb.leetcode.topic_2049;

import java.util.ArrayList;
import java.util.List;

/**
 * 2049. 统计最高分的节点数目
 * https://leetcode-cn.com/problems/count-nodes-with-the-highest-score/
 */
class Solution {

    long maxScore = 0;
    int cnt = 0;
    int n;
    List<Integer>[] children;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            int p = parents[i];
            if (p != -1) {
                children[p].add(i);
            }
        }
        dfs(0);
        return cnt;
    }

    private int dfs(int node) {
        long score = 1;
        int nodeCount = 1;
        for (int num : children[node]) {
            int t = dfs(num);
            score *= t;
            nodeCount += t;
        }
        if (node != 0) {
            // 当不为根节点时，还需乘以另一半的数目
            score *= n - nodeCount;
        }
        // 最大分数和出现次数统计
        if (score == maxScore) {
            cnt++;
        } else if (score > maxScore) {
            maxScore = score;
            cnt = 1;
        }
        return nodeCount;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0}));
        //System.out.println(solution.countHighestScoreNodes(new int[]{-1, 2, 0}));
        //[-1,3,3,5,7,6,0,0]  2
        System.out.println(solution.countHighestScoreNodes(new int[]{-1, 3, 3, 5, 7, 6, 0, 0}));
    }
}