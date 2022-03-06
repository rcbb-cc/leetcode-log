package cc.rcbb.leetcode.topic_337;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
class Solution1 {

    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 返回一个大小为 2 的数组
     * arr[0] 表示不抢root得到的最大数
     * arr[1] 表示抢root得到的最大数
     */
    int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);

        // 抢，下家就不能抢了
        int rob = root.val + left[0] + right[0];
        // 不抢，下家可抢可不抢，看收益大小
        int notRob = Math.max(left[0], left[1]) +
                Math.max(right[0], right[1]);
        return new int[]{notRob, rob};
    }
}