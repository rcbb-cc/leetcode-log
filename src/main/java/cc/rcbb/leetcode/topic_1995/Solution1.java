package cc.rcbb.leetcode.topic_1995;


import java.util.HashMap;
import java.util.Map;

/**
 * 1995. 统计特殊四元组
 * https://leetcode-cn.com/problems/count-special-quadruplets/
 */
class Solution1 {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int c = n - 2; c >= 2; c--) {
            map.put(nums[c + 1], map.getOrDefault(nums[c + 1], 0) + 1);
            for (int a = 0; a < c - 1; a++) {
                for (int b = a + 1; b < c; b++) {
                    count += map.getOrDefault(nums[a] + nums[b] + nums[c], 0);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        //输入：nums = [1,2,3,6]
        //输出：1
        //解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
        System.out.println(solution.countQuadruplets(new int[]{1, 2, 3, 6}));

        //输入：nums = [3,3,6,4,5]
        //输出：0
        //解释：[3,3,6,4,5] 中不存在满足要求的四元组。
        System.out.println(solution.countQuadruplets(new int[]{3, 3, 6, 4, 5}));

        //输入：nums = [1,1,1,3,5]
        //输出：4
        //解释：满足要求的 4 个四元组如下：
        //- (0, 1, 2, 3): 1 + 1 + 1 == 3
        //- (0, 1, 3, 4): 1 + 1 + 3 == 5
        //- (0, 2, 3, 4): 1 + 1 + 3 == 5
        //- (1, 2, 3, 4): 1 + 1 + 3 == 5
        System.out.println(solution.countQuadruplets(new int[]{1, 1, 1, 3, 5}));
        // 1
        System.out.println(solution.countQuadruplets(new int[]{28, 8, 49, 85, 37, 90, 20, 8}));
    }
}