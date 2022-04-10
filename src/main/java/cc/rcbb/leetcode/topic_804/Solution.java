package cc.rcbb.leetcode.topic_804;

import java.util.HashSet;
import java.util.Set;

/**
 * 804. 唯一摩尔斯密码词
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 */
class Solution {

    String[] arr = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(arr[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        System.out.println(solution.uniqueMorseRepresentations(new String[]{"a"}));
    }
}