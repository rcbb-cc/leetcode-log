package cc.rcbb.leetcode.topic_2100;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * 2100. 适合打劫银行的日子
 * https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank/
 */
class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> res = new ArrayList<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            if (security[n - i - 1] <= security[n - i]) {
                right[n - i - 1] = right[n - i] + 1;
            }
        }
        for (int i = time; i < n - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：security = [5,3,3,3,5,6,2], time = 2
        //输出：[2,3]
        //解释：
        //第 2 天，我们有 security[0] >= security[1] >= security[2] <= security[3] <= security[4] 。
        //第 3 天，我们有 security[1] >= security[2] >= security[3] <= security[4] <= security[5] 。
        //没有其他日子符合这个条件，所以日子 2 和 3 是适合打劫银行的日子。
        RcbbPrinter.print(solution.goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2));
        //输入：security = [1,1,1,1,1], time = 0
        //输出：[0,1,2,3,4]
        //解释：
        //因为 time 等于 0 ，所以每一天都是适合打劫银行的日子，所以返回每一天。
        RcbbPrinter.print(solution.goodDaysToRobBank(new int[]{1, 1, 1, 1, 1}, 0));
        //输入：security = [1,2,3,4,5,6], time = 2
        //输出：[]
        //解释：
        //没有任何一天的前 2 天警卫数目是非递增的。
        //所以没有适合打劫银行的日子，返回空数组。
        RcbbPrinter.print(solution.goodDaysToRobBank(new int[]{1, 2, 3, 4, 5, 6}, 2));
        //输入：security = [1], time = 5
        //输出：[]
        //解释：
        //没有日子前面和后面有 5 天时间。
        //所以没有适合打劫银行的日子，返回空数组。
        RcbbPrinter.print(solution.goodDaysToRobBank(new int[]{1}, 5));

        //[3,1,20,17,26,0,2,29,24]
        //输出：[]
        RcbbPrinter.print(solution.goodDaysToRobBank(new int[]{3, 1, 20, 17, 26, 0, 2, 29, 24}, 3));
    }

}