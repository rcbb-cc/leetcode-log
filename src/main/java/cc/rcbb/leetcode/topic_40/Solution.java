package cc.rcbb.leetcode.topic_40;

import java.util.*;

/**
 * 40. 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        Arrays.sort(candidates);
        f(0, candidates, target, cur, res);
        return new ArrayList<>(res);
    }

    public void f(int index, int[] candidates, int target, LinkedList<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            // 同一层数值相同的结点，因为数值相同，前面已经搜索出了包含了这个数值的全部结果，所以直接跳过
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            cur.add(candidates[i]);
            f(i + 1, candidates, target - candidates[i], cur, res);
            cur.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入: candidates =[10,1,2,7,6,1,5], target =8,
        //输出:
        //    [
        //    [1,1,6],
        //    [1,2,5],
        //    [1,7],
        //    [2,6]
        //    ]
        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        //输入: candidates = [2,5,2,1,2], target = 5,
        //输出:
        //[
        //[1,2,2],
        //[5]
        //]
        System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        //[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
        //30
        System.out.println(solution.combinationSum2(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 30));
    }
}