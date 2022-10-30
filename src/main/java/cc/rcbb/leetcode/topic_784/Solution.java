package cc.rcbb.leetcode.topic_784;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 784. 字母大小写全排列
 * https://leetcode.cn/problems/letter-case-permutation/
 * <p>
 * BFS、回溯
 */
class Solution {

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s.toCharArray(), 0, ans);
        return ans;
    }

    /**
     * 回溯
     *
     * @param arr
     * @param pos
     * @param res
     */
    public void dfs(char[] arr, int pos, List<String> res) {
        while (pos < arr.length && Character.isDigit(arr[pos])) {
            pos++;
        }
        if (pos == arr.length) {
            res.add(new String(arr));
            return;
        }
        arr[pos] ^= 32;
        dfs(arr, pos + 1, res);
        arr[pos] ^= 32;
        dfs(arr, pos + 1, res);
    }

    /**
     * BFS
     *
     * @param s
     * @return
     */
    public List<String> letterCasePermutation1(String s) {
        List<String> ans = new ArrayList<>();
        Queue<StringBuilder> queue = new ArrayDeque<>();
        queue.offer(new StringBuilder());
        while (!queue.isEmpty()) {
            StringBuilder curr = queue.peek();
            if (curr.length() == s.length()) {
                ans.add(curr.toString());
                queue.poll();
            } else {
                int pos = curr.length();
                if (Character.isLetter(s.charAt(pos))) {
                    StringBuilder next = new StringBuilder(curr);
                    next.append((char) (s.charAt(pos) ^ 32));
                    queue.offer(next);
                }
                curr.append(s.charAt(pos));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCasePermutation("a1b2");
        solution.letterCasePermutation("3z4");
    }
}