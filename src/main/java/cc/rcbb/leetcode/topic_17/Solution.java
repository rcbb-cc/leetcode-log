package cc.rcbb.leetcode.topic_17;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
class Solution {
    Map<String, String[]> map = new HashMap<String, String[]>() {{
        put("2", new String[]{"a", "b", "c"});
        put("3", new String[]{"d", "e", "f"});
        put("4", new String[]{"g", "h", "i"});
        put("5", new String[]{"j", "k", "l"});
        put("6", new String[]{"m", "n", "o"});
        put("7", new String[]{"p", "q", "r", "s"});
        put("8", new String[]{"t", "u", "v"});
        put("9", new String[]{"w", "x", "y", "z"});
    }};

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        f(digits, 0, n, sb, res);
        return res;
    }

    public void f(String digits, int i, int n, StringBuilder sb, List<String> res) {
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }
        String key = digits.substring(i, i + 1);
        String[] all = map.get(key);
        for (String s : all) {
            sb.append(s);
            f(digits, i + 1, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：digits = "23"
        //输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(solution.letterCombinations("23"));
        //输入：digits = ""
        //输出：[]
        System.out.println(solution.letterCombinations(""));
        //输入：digits = "2"
        //输出：["a","b","c"]
        System.out.println(solution.letterCombinations("2"));
    }
}