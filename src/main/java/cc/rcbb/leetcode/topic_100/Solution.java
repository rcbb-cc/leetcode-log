package cc.rcbb.leetcode.topic_100;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 */
class Solution {
    /**
     * 最简单的思路：
     * 1.遍历两棵树，使用list存储起来；
     * 2.对比两个list的长度；
     * 3.一个个对比list中的数据；
     * <p>
     * 注意点：使用什么方式遍历？先序？中序？
     * <p>
     * 中序会有一种数据过不了，[1,1] [1,null,1]
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> lp = new ArrayList<>();
        List<Integer> lq = new ArrayList<>();
        dfs(lp, p);
        dfs(lq, q);
        if (lp.size() != lq.size()) {
            return false;
        }
        for (int i = 0; i < lp.size(); i++) {
            Integer iq = lq.get(i);
            Integer ip = lp.get(i);
            if (!iq.equals(ip)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 先序遍历
     */
    public void dfs(List<Integer> list, TreeNode root) {
        if (root == null) {
            // 将null错特殊数据存储
            list.add(-100001);
            return;
        }
        list.add(root.val);
        dfs(list, root.left);
        dfs(list, root.right);
    }

    public static void main(String[] args) {
        // 中序遍历无法识别这种
        //[1,1]
        //[1,null,1]
        Solution solution = new Solution();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(1);
        p.right = null;

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(1);
        q.left = null;

        solution.isSameTree(p, q);
    }
}