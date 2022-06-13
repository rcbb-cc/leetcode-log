package cc.rcbb.leetcode.topic_890;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 890. 查找和替换模式
 * https://leetcode.cn/problems/find-and-replace-pattern/
 */
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        int[] map = new int[26], vis = new int[26];
        for (String word : words) {
            Arrays.fill(map, -1);
            Arrays.fill(vis, 0);
            boolean flag = true;
            for (int i = 0; i < pattern.length() && flag; i++) {
                int c1 = word.charAt(i) - 'a';
                int c2 = pattern.charAt(i) - 'a';
                if (map[c1] == -1 && vis[c2] == 0) {
                    map[c1] = c2;
                    vis[c2] = 1;
                } else if (map[c1] != c2) {
                    flag = false;
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }
}