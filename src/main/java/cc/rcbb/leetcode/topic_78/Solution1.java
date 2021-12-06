package cc.rcbb.leetcode.topic_78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 */
class Solution1 {

    ArrayList<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        f(nums, 0, new LinkedList<Integer>());
        return result;
    }

    /**
     * 回溯
     */
    public void f(int[] nums, int start, LinkedList<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            f(nums, i + 1, path);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = new int[]{1, 2, 3};
        // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }
}