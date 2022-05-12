package cc.rcbb.leetcode.topic_300;

import java.util.*;

/**
 * 300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
class Solution {
    /**
     * 贪心 + 二分
     */
    public int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                d[len++] = nums[i];
            } else {
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    /**
     * 动规 + 二分
     */
    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
                // 把 num 插入到 tail 数组合适的位置
                tails[i] = num;
                // j=res 说明 tail 数组中的元素都比 num小，因此最长子序列的长度可以更新了
                if (j == res) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 动态规划
     */
    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：nums = [0,1,0,3,2,3]
        //输出：4
        //int[] nums = new int[]{0, 1, 0, 3, 2, 3};

        //输入：nums = [10,9,2,5,3,7,101,18]
        //输出：4
        //解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

        //输入：nums = [7,7,7,7,7,7,7]
        //输出：1
        // int[] nums = new int[]{7,7,7,7,7,7,7};
        int max = solution.lengthOfLIS(nums);
        System.out.println(max);

    }
}