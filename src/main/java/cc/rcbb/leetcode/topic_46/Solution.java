package cc.rcbb.leetcode.topic_46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length > 0) {
            LinkedList<Integer> list = new LinkedList<>();
            backtrack(nums, list);
        }
        return result;
    }

    public void backtrack(int[] nums, LinkedList<Integer> list) {
        if (nums.length == list.size()) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：nums = [1,2,3]
        //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }
}