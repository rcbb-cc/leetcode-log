package cc.rcbb.leetcode.topic_1805;

import java.util.HashSet;
import java.util.Set;

/**
 * 1805. 字符串中不同整数的数目
 * https://leetcode.cn/problems/number-of-different-integers-in-a-string/
 * <p>
 * 双指针
 */
class Solution {
    public int numDifferentIntegers(String word) {

        Set<String> set = new HashSet<>();
        int n = word.length();
        int p1 = 0, p2 = 0;
        while (true) {
            while (p1 < n && !Character.isDigit(word.charAt(p1))) {
                p1++;
            }
            if (p1 == n) {
                break;
            }
            p2 = p1;
            while (p2 < n && Character.isDigit(word.charAt(p2))) {
                p2++;
            }
            // 去除前导0
            while (p2 - p1 > 1 && word.charAt(p1) == '0') {
                p1++;
            }
            set.add(word.substring(p1, p2));
            p1 = p2;
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(solution.numDifferentIntegers("leet1234code234"));
        System.out.println(solution.numDifferentIntegers("a1b01c001"));
    }
}