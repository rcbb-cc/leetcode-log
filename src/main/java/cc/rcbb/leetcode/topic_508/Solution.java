package cc.rcbb.leetcode.topic_508;

import cc.rcbb.leetcode.template.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. 出现次数最多的子树元素和
 * https://leetcode.cn/problems/most-frequent-subtree-sum/
 */
class Solution {
    Map<Integer, Integer> countMap = new HashMap<>();

    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        f(root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int s = entry.getKey();
            int c = entry.getValue();
            if (c == max) {
                list.add(s);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    int f(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = f(root.left) + f(root.right) + root.val;
        int count = countMap.getOrDefault(sum, 0) + 1;
        countMap.put(sum, count);
        max = Math.max(max, count);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(-3);

        five.left = two;
        five.right = three;
        Solution solution = new Solution();
        solution.findFrequentTreeSum(five);
    }
}