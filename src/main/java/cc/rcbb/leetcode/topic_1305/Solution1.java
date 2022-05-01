package cc.rcbb.leetcode.topic_1305;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 */
class Solution1 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        f(root1, list1);
        f(root2, list2);

        List<Integer> merged = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (true) {
            if (p1 == list1.size()) {
                merged.addAll(list2.subList(p2, list2.size()));
                break;
            }
            if (p2 == list2.size()) {
                merged.addAll(list1.subList(p1, list1.size()));
                break;
            }
            if (list1.get(p1) < list2.get(p2)) {
                merged.add(list1.get(p1++));
            } else {
                merged.add(list2.get(p2++));
            }
        }
        return merged;
    }

    public void f(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        f(root.left, result);
        result.add(root.val);
        f(root.right, result);
    }
}