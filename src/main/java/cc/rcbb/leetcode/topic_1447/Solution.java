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
            int j = i + 1;
            while (j <= n) {
                if (j % i != 0 && check(i,j)) {
                    res.add(i + "/" + j);
                } else if (i == 1 && check(i,j)) {
                    res.add(i + "/" + j);
                }
                j++;
            }
        }
        return res;
    }
    public boolean check(int i, int j) {
        for (int k = 2; k < i; k++) {
            if (i % k == 0 && j % k == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifiedFractions(1));
        System.out.println(solution.simplifiedFractions(2));
        System.out.println(solution.simplifiedFractions(3));
        System.out.println(solution.simplifiedFractions(4));
        System.out.println(solution.simplifiedFractions(10));
        //System.out.println(solution.simplifiedFractions(33));
    }

}