package cc.rcbb.leetcode.topic_71;

import java.util.LinkedList;

/**
 * 71. 简化路径
 * https://leetcode-cn.com/problems/simplify-path/
 */
class Solution {
    public String simplifyPath(String path) {
        String[] array = path.split("/");
        LinkedList<String> q = new LinkedList<>();
        for (String s : array) {
            if (".".equals(s) || "".equals(s)) {
                continue;
            } else if ("..".equals(s)) {
                if (!q.isEmpty()) {
                    q.removeLast();
                }
            } else {
                q.addLast(s);
            }
        }
        StringBuilder res = new StringBuilder("/");
        while (!q.isEmpty()) {
            res.append(q.poll());
            int size = q.size();
            if (size != 0) {
                res.append("/");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        // /a/b/c
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
        // /
        System.out.println(solution.simplifyPath("/../"));
    }
}