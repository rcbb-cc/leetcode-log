package cc.rcbb.leetcode.topic_1995;

/**
 * 1995. 统计特殊四元组
 * https://leetcode-cn.com/problems/count-special-quadruplets/
 */
class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

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

        System.out.println(solution.countQuadruplets(new int[]{28, 8, 49, 85, 37, 90, 20, 8}));
    }
}