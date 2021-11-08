package cc.rcbb.leetcode.topic_438;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        char[] pArray = p.toCharArray();
        for (int i = 0; i < pArray.length; i++) {
            need.put(pArray[i], need.getOrDefault(pArray[i], 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> result = new ArrayList<>();
        char[] sArray = s.toCharArray();
        while (right < sArray.length) {
            char c = sArray[right];
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            if (right - left >= pArray.length) {
                if (valid == need.size()) {
                    result.add(left);
                }
                char d = sArray[left];
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入: s = "cbaebabacd", p = "abc" 输出: [0,6]
        //String s = "cbaebabacd";
        //String p = "abc";

        // 输入: s = "abab", p = "ab"  输出: [0,1,2]
        String s = "abab";
        String p = "ab";
        List<Integer> r = solution.findAnagrams(s, p);
        RcbbPrinter.print(r);
    }
}