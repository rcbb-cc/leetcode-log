package cc.rcbb.leetcode.template;

import java.util.Stack;

/**
 * 单调栈解题模版：
 *      单调栈用途不太广泛，只处理一种典型的问题，叫做 Next Greater Element。
 */
public class MonotonStackTemplate {

    public int[] nextGreaterElements(int[] nums) {
        // 存放答案的数组
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = nums.length - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了
                s.pop();
            }
            // nums[i] 身后的 next great number
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

}
