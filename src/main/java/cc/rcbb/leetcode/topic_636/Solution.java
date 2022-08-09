package cc.rcbb.leetcode.topic_636;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 636. 函数的独占时间
 * https://leetcode.cn/problems/exclusive-time-of-functions/
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for (String log : logs) {
            int idx = Integer.parseInt(log.substring(0, log.indexOf(":")));
            String type = log.substring(log.indexOf(":") + 1, log.lastIndexOf(":"));
            int timestamp = Integer.parseInt(log.substring(log.lastIndexOf(":") + 1));
            // 当类型是 start 时
            if ("start".equals(type)) {
                // 栈内不为空
                if (!stack.isEmpty()) {
                    // 累加函数时间，用当前函数的 timestamp 减去 栈顶函数的 timestamp
                    res[stack.peek()[0]] += timestamp - stack.peek()[1];
                    // 并更新当前栈顶函数的 timestamp 为当前函数开始时间
                    stack.peek()[1] = timestamp;
                }
                // 将当前函数入栈
                stack.push(new int[]{idx, timestamp});
            } else {
                // 当类型是 end
                int[] t = stack.pop();
                // 累加函数时间，用当前函数的 timestamp 减去 栈顶函数的 timestamp 并加 1
                res[t[0]] += timestamp - t[1] + 1;
                if (!stack.isEmpty()) {
                    // 栈内不为空，并更新当前栈顶函数的 timestamp 为当前函数开始时间 并加 1
                    stack.peek()[1] = timestamp + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        RcbbPrinter.print(solution.exclusiveTime(2, List.of("0:start:0", "1:start:2", "1:end:5", "0:end:6")));
        RcbbPrinter.print(solution.exclusiveTime(1, List.of("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7")));
        RcbbPrinter.print(solution.exclusiveTime(2, List.of("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7")));
        RcbbPrinter.print(solution.exclusiveTime(2, List.of("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8")));
        RcbbPrinter.print(solution.exclusiveTime(1, List.of("0:start:0", "0:end:0")));
    }
}