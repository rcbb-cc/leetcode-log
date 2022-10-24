package cc.rcbb.leetcode.topic_915;

/**
 * 915. 分割数组
 * https://leetcode.cn/problems/partition-array-into-disjoint-intervals/
 * <p>
 * 模拟
 */
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int leftMax = nums[0], leftPos = 0, curMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curMax;
                leftPos = i;
            }
        }
        return leftPos + 1;
    }

    public int partitionDisjoint1(int[] nums) {
        int n = nums.length;
        int left = 0;
        int leftMax = nums[0];
        for (int i = left; i < n; ) {
            boolean flag = true;
            int tempMax = leftMax;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < leftMax) {
                    i = j;
                    leftMax = tempMax;
                    flag = false;
                    break;
                } else {
                    tempMax = Math.max(tempMax, nums[j]);
                }
            }
            if (flag) {
                left = i;
                break;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
        System.out.println(solution.partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}));
    }
}