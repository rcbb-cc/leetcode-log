package cc.rcbb.leetcode.topic_1775;

/**
 * 1775. 通过最少操作次数使数组的和相等
 * https://leetcode.cn/problems/equal-sum-arrays-with-minimum-number-of-operations/
 * <p>
 * 贪心
 */
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (6 * n < m || 6 * m < n) {
            return -1;
        }
        int[] cnt1 = new int[7];
        int[] cnt2 = new int[7];
        int diff = 0;
        for (int i : nums1) {
            cnt1[i]++;
            diff += i;
        }
        for (int i : nums2) {
            cnt2[i]++;
            diff -= i;
        }
        if (diff == 0) {
            return 0;
        }
        if (diff > 0) {
            return help(cnt2, cnt1, diff);
        }
        return help(cnt1, cnt2, -diff);
    }

    public int help(int[] h1, int[] h2, int diff) {
        int[] h = new int[7];
        for (int i = 1; i < 7; i++) {
            h[6 - i] += h1[i];
            h[i - 1] += h2[i];
        }
        int res = 0;
        for (int i = 5; i > 0 && diff > 0; i--) {
            int t = Math.min((diff + i - 1) / i, h[i]);
            res += t;
            diff -= t * i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2}));
        System.out.println(solution.minOperations(new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{6}));
    }
}
