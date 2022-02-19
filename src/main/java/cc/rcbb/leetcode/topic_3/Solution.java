package cc.rcbb.leetcode.topic_3;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < n) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // 当出现重复时，窗口移动
            while (map.get(c) > 1) {
                char d = s.charAt(left);
                map.put(d, map.get(d) - 1);
                left++;
            }
            count = Integer.max(count, right - left + 1);
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入: s = "abcabcbb" 输出: 3
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        //String s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        //String s = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        //String s = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}