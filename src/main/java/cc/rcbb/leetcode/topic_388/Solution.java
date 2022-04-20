package cc.rcbb.leetcode.topic_388;

import java.util.*;

/**
 * 388. 文件的最长绝对路径
 * https://leetcode-cn.com/problems/longest-absolute-file-path/
 */
class Solution {

    public int lengthLongestPath(String input) {
        Map<Integer, String> map = new HashMap<>();
        int n = input.length();
        String ans = null;
        int i = 0;
        while (i < n) {
            int level = 0;
            while (i < n && input.charAt(i) == '\t') {
                i++;
                level++;
            }
            int j = i;
            boolean isDir = true;
            while (j < n && input.charAt(j) != '\n') {
                if (input.charAt(j) == '.') {
                    isDir = false;
                }
                j++;
            }
            String cur = input.substring(i, j);
            String prev = map.getOrDefault(level - 1, null);
            String path = prev == null ? cur : prev + "/" + cur;
            if (isDir) {
                map.put(level, path);
            } else if (ans == null || path.length() > ans.length()) {
                ans = path;
            }
            i = j + 1;
        }
        return ans == null ? 0 : ans.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}