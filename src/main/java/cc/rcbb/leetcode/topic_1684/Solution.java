package cc.rcbb.leetcode.topic_1684;

/**
 * 1684. 统计一致字符串的数目
 * https://leetcode.cn/problems/count-the-number-of-consistent-strings/
 * <p>
 * 模拟
 */
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] visit = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            visit[allowed.charAt(i) - 'a'] = true;
        }
        int count = 0;
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (visit[word.charAt(i) - 'a'] == false) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
        System.out.println(solution.countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}));
        System.out.println(solution.countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));
    }
}