package cc.rcbb.leetcode.topic_567;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        char[] needArray = s1.toCharArray();
        for (int i = 0; i < needArray.length; i++) {
            need.put(needArray[i], need.getOrDefault(needArray[i], 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        char[] windowArray = s2.toCharArray();

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < windowArray.length) {
            char c = windowArray[right];
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            // 因为是排列，所以长度应该是一样的
            while (right - left >= s1.length()) {
                // valied
                if (valid == need.size()) {
                    return true;
                }
                char d = windowArray[left];
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 输入：s1 = "ab" s2 = "eidbaooo" 输出：true
        //String s1 = "ab";
        //String s2 = "eidbaooo";

        // 输入：s1= "ab" s2 = "eidboaoo" 输出：false
        //String s1 = "ab";
        //String s2 = "eidboaoo";

        // false
        //String s1 ="hello";
        //String s2 = "ooolleoooleh";

        // true
        String s1 ="abcdxabcde";
        String s2 = "abcdeabcdx";
        boolean b = solution.checkInclusion(s1, s2);
        System.out.println(b);

    }
}