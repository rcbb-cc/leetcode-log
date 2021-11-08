package cc.rcbb.leetcode.topic_3;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int res = 0;

        char[] sArray = s.toCharArray();
        while (right < sArray.length) {

            char c = sArray[right];
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = sArray[left];
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Integer.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 输入: s = "abcabcbb" 输出: 3
        //String s = "abcabcbb";
        //String s = "bbbbb";
        //String s = "pwwkew";
        String s = "";

        int r = solution.lengthOfLongestSubstring(s);
        System.out.println(r);

    }
}