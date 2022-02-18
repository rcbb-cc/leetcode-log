package cc.rcbb.leetcode.topic_216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * https://leetcode-cn.com/problems/combination-sum-iii/
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        f(1, k, n, 0, cur, res);
        return res;
    }

    public void f(int index, int k, int n, int sum, LinkedList<Integer> cur, List<List<Integer>> res) {
        if (n == sum && cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (sum > n || cur.size() > k) {
            return;
        }
        // 只允许含有 1 - 9 的正整数
        for (int i = index; i < n && i < 10; i++) {
            cur.add(i);
            f(i + 1, k, n, sum + i, cur, res);
            cur.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //示例 1:
        //输入: k = 3, n = 7
        //输出: [[1,2,4]]

        System.out.println(solution.combinationSum3(3, 7));

        //示例 2:
        //输入: k = 3, n = 9
        //输出: [[1,2,6], [1,3,5], [2,3,4]]
        System.out.println(solution.combinationSum3(3, 9));

        System.out.println(solution.combinationSum3(9, 45));
        System.out.println(solution.combinationSum3(2, 18));
    }

}