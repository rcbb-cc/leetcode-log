package cc.rcbb.leetcode.topic_553;

/**
 * 553. 最优除法
 * https://leetcode-cn.com/problems/optimal-division/
 */
class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(nums[i]);
            if (i < n - 1) {
                res.append("/");
            }
        }
        if (n > 2) {
            res.insert(res.indexOf("/") + 1, "(");
            res.append(")");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.optimalDivision(new int[]{1000, 100, 10, 2}));
    }
}