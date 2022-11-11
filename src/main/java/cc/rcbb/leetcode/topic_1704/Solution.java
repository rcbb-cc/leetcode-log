package cc.rcbb.leetcode.topic_1704;

import java.util.Set;

/**
 * 1704. 判断字符串的两半是否相似
 * https://leetcode.cn/problems/determine-if-string-halves-are-alike/
 * <p>
 * 模拟
 */
class Solution {

    public boolean halvesAreAlike(String s) {
        int n = s.length();
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
        }
        for (int i = n / 2; i < n; i++) {
            if (set.contains(s.charAt(i))) {
                count--;
            }
        }
        return count == 0 ? true : false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.halvesAreAlike("book"));
        System.out.println(solution.halvesAreAlike("textbook"));
    }
}