package cc.rcbb.leetcode.topic_100;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 */
class Solution1 {
    /**
     * 递归方式
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (q == null || q == null) {
            return false;
        }
        if (q.val != p.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public static void main(String[] args) {
        // 中序遍历无法识别这种
        //[1,1]
        //[1,null,1]
        Solution1 solution = new Solution1();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(1);
        p.right = null;

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(1);
        q.left = null;

        boolean sameTree = solution.isSameTree(p, q);
        System.out.println(sameTree);
    }
}