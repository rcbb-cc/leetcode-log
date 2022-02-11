package cc.rcbb.leetcode.topic_1447;

import java.util.ArrayList;
import java.util.List;

/**
 * 1447. 最简分数
 * https://leetcode-cn.com/problems/simplified-fractions/
 */
class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (i == 1) {
                    res.add(i + "/" + j);
                } else if (j % i != 0 && check(i, j)) {
                    res.add(i + "/" + j);
                }
            }
        }
        return res;
    }

    public boolean check(int i, int j) {
        if (this.f(i, j) == 1) {
            return true;
        }
        return false;
    }

    // 辗转相除法（别名：欧几里得算法）
    public int f(int i, int j) {
        while (j != 0) {
            int b = i % j;
            i = j;
            j = b;
        }
        return i;
    }

    int gcd(int a, int b) { // 欧几里得算法
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifiedFractions(1));
        System.out.println(solution.simplifiedFractions(2));
        System.out.println(solution.simplifiedFractions(3));
        System.out.println(solution.simplifiedFractions(4));
        System.out.println(solution.simplifiedFractions(10));
        //System.out.println(solution.simplifiedFractions(33));

        System.out.println();
        System.out.println(solution.f(1, 2));
        System.out.println(solution.f(2, 4));
        System.out.println(solution.f(3, 6));
        System.out.println(solution.f(7, 8));
        System.out.println(solution.f(8, 10));
    }

}