package cc.rcbb.leetcode.topic_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 */
class Solution1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        // 进行排序
        Arrays.sort(candidates);
        f(candidates, 0, target, list, res);
        return res;
    }

    private void f(int[] candidates, int index, int target, LinkedList<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 当target减去当前数字都小于0时，后续就不需要尝试了
            if (target - candidates[i] < 0) {
                break;
            }
            list.add(candidates[i]);
            f(candidates, i, target - candidates[i], list, res);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(solution.combinationSum(new int[]{2}, 1));
    }
}