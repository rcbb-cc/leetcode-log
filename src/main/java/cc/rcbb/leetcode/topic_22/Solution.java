package cc.rcbb.leetcode.topic_22;


import java.util.LinkedList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
class Solution {
    private List<String> result = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        f("", 0, 0, n);
        return result;
    }

    public void f(String ans, int leftCount, int rightCount, int n) {
        if (leftCount > n || rightCount > n) {
            return;
        }
        if (leftCount == n && rightCount == n) {
            result.add(ans);
        }
        if (leftCount >= rightCount) {
            f(ans + "(", leftCount + 1, rightCount, n);
            f(ans + ")", leftCount, rightCount + 1, n);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String> list = solution.generateParenthesis(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}