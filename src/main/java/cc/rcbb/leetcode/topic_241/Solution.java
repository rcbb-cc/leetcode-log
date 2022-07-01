package cc.rcbb.leetcode.topic_241;


import java.util.ArrayList;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * https://leetcode.cn/problems/different-ways-to-add-parentheses/
 */
class Solution {
    static final int ADD = -1;
    static final int SUB = -2;
    static final int MUL = -3;

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ops = new ArrayList<>();
        for (int i = 0; i < expression.length(); ) {
            if (!Character.isDigit(expression.charAt(i))) {
                if (expression.charAt(i) == '+') {
                    ops.add(ADD);
                } else if (expression.charAt(i) == '-') {
                    ops.add(SUB);
                } else {
                    ops.add(MUL);
                }
                i++;
            } else {
                int t = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    t = t * 10 + expression.charAt(i) - '0';
                    i++;
                }
                ops.add(t);
            }
        }
        List<Integer>[][] dp = new List[ops.size()][ops.size()];
        for (int i = 0; i < ops.size(); i++) {
            for (int j = 0; j < ops.size(); j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        return dfs(dp, 0, ops.size() - 1, ops);
    }

    public List<Integer> dfs(List<Integer>[][] dp, int l, int r, List<Integer> ops) {
        if (dp[l][r].isEmpty()) {
            if (l == r) {
                dp[l][r].add(ops.get(l));
            } else {
                for (int i = l; i < r; i += 2) {
                    List<Integer> left = dfs(dp, l, i, ops);
                    List<Integer> right = dfs(dp, i + 2, r, ops);
                    for (int lv : left) {
                        for (int rv : right) {
                            if (ops.get(i + 1) == ADD) {
                                dp[l][r].add(lv + rv);
                            } else if (ops.get(i + 1) == SUB) {
                                dp[l][r].add(lv - rv);
                            } else {
                                dp[l][r].add(lv * rv);
                            }
                        }
                    }
                }
            }
        }
        return dp[l][r];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2-1-1"));
        System.out.println(solution.diffWaysToCompute("2*3-4*5"));
    }
}