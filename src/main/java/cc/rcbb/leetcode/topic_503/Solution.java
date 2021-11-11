package cc.rcbb.leetcode.topic_503;

import cc.rcbb.leetcode.common.RcbbPrinter;
import cc.rcbb.leetcode.template.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 */
public class Solution {

    /**
     * 思路：
     *  1.循环数组常用套路：将数组长度翻倍；
     *  2.单调栈，借助栈的结构，倒着入栈；
     */
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % length]) {
                stack.pop();
            }
            result[i % length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % length]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /**
         * 输入: [1,2,1]
         * 输出: [2,-1,2]
         * 解释: 第一个 1 的下一个更大的数是 2；
         * 数字 2 找不到下一个更大的数；
         * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
         *
         */
        int[] nums = new int[]{1, 2, 1};

        /**
         * 输入
         * [1,2,3,4,3]
         * 预期结果
         * [2,3,4,-1,4]
         */
        //int[] nums = new int[]{1, 2, 3, 4, 3};

        int[] result = solution.nextGreaterElements(nums);
        RcbbPrinter.print(result);

        // 0 1 2
        // 0 1 2 3 4
        cyclingArray();

    }

    private static void cyclingArray() {
        int[] nums = new int[]{1, 2, 3};
        int length = nums.length;
        for (int i = 2 * length - 2; i >= 0; i--) {
            System.out.println(nums[i % length]);
        }
    }
}