package cc.rcbb.leetcode.topic_496;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class Solution {

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int j = 0;
            // 找出大于nums1[i]的j
            while (j < m && nums1[i] != nums2[j]) {
                j++;
            }
            while (j < m && nums1[i] >= nums2[j]) {
                j++;
            }
            // 如果j没超范围，则取其结果，否则为-1
            ans[i] = j < m ? nums2[j] : -1;
        }
        return ans;
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        nextGreaterElements(nums2, map);
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    public void nextGreaterElements(int[] nums, Map<Integer, Integer> map) {
        // 存放答案的数组
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = nums.length - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了
                s.pop();
            }
            // nums[i] 身后的 next great number
            map.put(nums[i], s.isEmpty() ? -1 : s.peek());
            s.push(nums[i]);
        }
    }


    public static void main(String[] args) {

        Solution solution = new Solution();

        /**
         * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
         * 输出: [-1,3,-1]
         * 解释:
         *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
         *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
         *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
         */
        //int[] nums1 = new int[]{4, 1, 2};
        //int[] nums2 = new int[]{1, 3, 4, 2};


        /**
         * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
         * 输出: [3,-1]
         * 解释:
         *    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
         *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
         */
        //int[] nums1 = new int[]{2,4};
        //int[] nums2 = new int[]{1,2,3,4};


        /**
         * 输入：
         * [1,3,5,2,4]
         * [6,5,4,3,2,1,7]
         * 预期结果：
         * [7,7,7,7,7]
         */
        int[] nums1 = new int[]{1, 3, 5, 2, 4};
        int[] nums2 = new int[]{6, 5, 4, 3, 2, 1, 7};

        int[] r = solution.nextGreaterElement(nums1, nums2);
        RcbbPrinter.print(r);
        /**
         * 提示：
         *
         * 1 <= nums1.length <= nums2.length <= 1000
         * 0 <= nums1[i], nums2[i] <= 104
         * nums1和nums2中所有整数 互不相同
         * nums1 中的所有整数同样出现在 nums2 中
         *
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/next-greater-element-i
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
    }


}