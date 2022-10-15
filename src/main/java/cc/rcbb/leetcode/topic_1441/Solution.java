package cc.rcbb.leetcode.topic_1441;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组
 * https://leetcode.cn/problems/build-an-array-with-stack-operations/
 */
class Solution {
    public List<String> buildArray(int[] target, int n) {
        int m = target.length;
        List<String> list = new ArrayList<>();
        for (int i = 1, j = 0; i <= n && j < m; i++) {
            list.add("Push");
            if (target[j] != i) {
                list.add("Pop");
            } else {
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.buildArray(new int[]{1, 3}, 3));
    }
}