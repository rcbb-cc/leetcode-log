package cc.rcbb.leetcode.topic_386;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * https://leetcode-cn.com/problems/lexicographical-numbers/
 */
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int curr = 1;
        for (int i = 0; i < n; i++) {
            res.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                while (curr % 10 == 9 || curr + 1 > n) {
                    curr /= 10;
                }
                curr++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.lexicalOrder(13));
        RcbbPrinter.print(solution.lexicalOrder(2));
        RcbbPrinter.print(solution.lexicalOrder(100));
    }
}