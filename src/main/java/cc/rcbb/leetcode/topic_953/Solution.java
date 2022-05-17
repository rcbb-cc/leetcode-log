package cc.rcbb.leetcode.topic_953;

import java.util.Arrays;

/**
 * 953. 验证外星语词典
 * https://leetcode.cn/problems/verifying-an-alien-dictionary/
 */
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArray = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderArray[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            boolean valid = false;
            for (int j = 0; j < words[i - 1].length() && j < words[i].length(); j++) {
                int prev = orderArray[words[i - 1].charAt(j) - 'a'];
                int curr = orderArray[words[i].charAt(j) - 'a'];
                if (prev < curr) {
                    valid = true;
                    break;
                } else if (prev > curr) {
                    return false;
                }
            }
            if (!valid) {
                if (words[i - 1].length() > words[i].length()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isAlienSorted1(String[] words, String order) {
        int[] orderArray = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderArray[order.charAt(i) - 'a'] = i;
        }
        String[] clone = words.clone();
        Arrays.sort(clone, (a, b) -> {
            int m = a.length(), n = b.length();
            int i = 0, j = 0;
            while (i < m && j < n) {
                int c1 = a.charAt(i) - 'a', c2 = b.charAt(j) - 'a';
                if (c1 != c2) {
                    return orderArray[c1] - orderArray[c2];
                }
                i++;
                j++;
            }
            if (i < m) {
                return 1;
            }
            if (j < n) {
                return -1;
            }
            return 0;
        });
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(clone[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
        // true
        System.out.println(solution.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        // 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
        // 输出：false
        System.out.println(solution.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"abc", "abcd"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}