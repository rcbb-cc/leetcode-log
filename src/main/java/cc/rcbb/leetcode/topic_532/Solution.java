package cc.rcbb.leetcode.topic_532;

import java.util.HashSet;
import java.util.Set;

/**
 * 532. 数组中的 k-diff 数对
 * https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 */
class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> visit = new HashSet<>();
        for (int num : nums) {
            if (visit.contains(num - k)) {
                res.add(num - k);
            }
            if (visit.contains(num + k)) {
                res.add(num);
            }
            visit.add(num);
        }
        return res.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    }
}