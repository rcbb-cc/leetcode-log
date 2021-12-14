package cc.rcbb.leetcode.topic_22;


import java.util.LinkedList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
class Solution1 {
    private List<String> result = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        f("", 0, 0, n);
        return result;
    }

    public void f(String ans, int count1, int count2, int n) {
        if (count1 > n || count2 > n) {
            return;
        }
        if (count1 == n && count2 == n) {
            result.add(ans);
        }
        if (count1 >= count2) {
            f(ans + "(", count1 + 1, count2, n);
            f(ans + ")", count1, count2 + 1, n);
        }
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        List<String> list = solution.generateParenthesis(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}