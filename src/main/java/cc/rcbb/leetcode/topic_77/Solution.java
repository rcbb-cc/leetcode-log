package cc.rcbb.leetcode.topic_77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 */
class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        f(1, n, k, new LinkedList<>());
        return result;
    }

    public void f(int start, int n, int k, LinkedList<Integer> path) {
        if (path.size() == k) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            f(i + 1, n, k, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combine(4, 2);
        System.out.println(Arrays.toString(result.toArray()));
    //    [[1, 2], [1, 3], [1, 4], [2, 2], [2, 3], [2, 4], [3, 2], [3, 3], [3, 4], [4, 2], [4, 3], [4, 4]]
    }
}