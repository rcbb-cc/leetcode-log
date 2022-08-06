package cc.rcbb.leetcode.topic_1408;


import java.util.ArrayList;
import java.util.List;

/**
 * 1408. 数组中的字符串匹配
 * https://leetcode.cn/problems/string-matching-in-an-array/
 */
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && words[i].contains(words[j])) {
                    result.add(words[j]);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：words = ["mass","as","hero","superhero"]
        // 输出：["as","hero"]
        // 解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
        // ["hero","as"] 也是有效的答案。
        System.out.println(solution.stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
        // 输入：words = ["leetcode","et","code"]
        // 输出：["et","code"]
        // 解释："et" 和 "code" 都是 "leetcode" 的子字符串。
        System.out.println(solution.stringMatching(new String[]{"leetcode", "et", "code"}));
        // 输入：words = ["blue","green","bu"]
        // 输出：[]
        System.out.println(solution.stringMatching(new String[]{"blue", "green", "bu"}));
    }
}