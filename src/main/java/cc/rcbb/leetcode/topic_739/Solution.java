package cc.rcbb.leetcode.topic_739;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        /**
         * 输入: temperatures = [73,74,75,71,69,72,76,73]
         * 输出: [1,1,4,2,1,1,0,0]
         */
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = solution.dailyTemperatures(temperatures);
        RcbbPrinter.print(res);
    }
}