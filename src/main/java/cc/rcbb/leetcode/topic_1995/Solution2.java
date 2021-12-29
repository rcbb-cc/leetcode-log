package cc.rcbb.leetcode.topic_1995;


import java.util.HashMap;
import java.util.Map;

/**
 * 1995. 统计特殊四元组
 * https://leetcode-cn.com/problems/count-special-quadruplets/
 */
class Solution2 {
    /**
     * 对公式nums[d] = nums[a] + nums[b] + nums[c]
     * 进行变换=>
     * 得到nums[d] - nums[c] = nums[a] + nums[b]，
     * 那么如果我们枚举出a,b，也就能确定nums[d]-nums[c]的值了。
     * 因此，我们可以把nums[d]-nums[c]所有可能的值加入到哈希表中，
     * 通过枚举a,b以及在哈希表中查找nums[d]-nums[c]来确定方案数。
     * 这样就又优化掉了一层循环。
     */
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2; d < n; d++) {
                map.put(nums[d] - nums[b + 1], map.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
            }
            for (int a = 0; a < b; a++) {
                count += map.getOrDefault(nums[a] + nums[b], 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

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