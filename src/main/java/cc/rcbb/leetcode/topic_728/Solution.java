package cc.rcbb.leetcode.topic_728;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. 自除数
 * https://leetcode-cn.com/problems/self-dividing-numbers/
 */
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int t = i;
            boolean flag = false;
            while (t != 0) {
                int y = t % 10;
                if (y == 0 || i % y != 0) {
                    flag = true;
                    break;
                }
                t /= 10;
            }
            if (flag) {
                continue;
            }
            result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：left = 1, right = 22
        //输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
        RcbbPrinter.print(solution.selfDividingNumbers(1, 22));
        //输入：left = 47, right = 85
        //输出：[48,55,66,77]
        RcbbPrinter.print(solution.selfDividingNumbers(47, 85));
    }
}