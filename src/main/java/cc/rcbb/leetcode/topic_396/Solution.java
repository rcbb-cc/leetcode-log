package cc.rcbb.leetcode.topic_396;


import java.util.Arrays;

/**
 * 396. 旋转函数
 * https://leetcode-cn.com/problems/rotate-function/
 */
class Solution {

    // 找规律题
    // sum:        a0 * 1 + a1 * 1 + a2 * 1 + a3 * 1
    // f(0):       a0 * 0 + a1 * 1 + a2 * 2 + a3 * 3
    // f(0) + sum: a0 * 1 + a1 * 2 + a2 * 3 + a3 * 4

    // f(1):        a3 * 0 + a0 * 1 + a1 * 2 + a2 * 3
    // f(1) + sum:  a3 * 1 + a0 * 2 + a1 * 3 + a2 * 4
    // f(1) = f(0) + sum - 4*a[4-1]

    // f(2):            a2 * 0 + a3 * 1 + a0 * 2 + a1 * 3
    // f(2) + sum:      a2 * 1 + a3 * 2 + a0 * 3 + a1 * 4
    // f(2) = f(1) + sum - 4*a[4-2]

    // f(3):  a1 * 0 +  a2 * 1 + a3 * 2 + a0 * 3
    // f(3) = f(2) + sum - 4*a[4-3]

    // 由上可得f(n) = f(n - 1) + sum - len * a[len - n]
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int numSum = Arrays.stream(nums).sum();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += i * nums[i];
        }
        for (int i = 1, cur = ans; i <= n; i++) {
            cur = cur + numSum - n * nums[n - i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public int maxRotateFunction1(int[] nums) {
        int n = nums.length;
        int[] sum = new int[2 * n + 10];
        for (int i = 1; i <= 2 * n; i++) {
            sum[i] = sum[i - 1] + nums[(i - 1) % n];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += nums[i - 1] * (i - 1);
        }
        for (int i = n + 1, cur = ans; i < 2 * n; i++) {
            cur += nums[(i - 1) % n] * (n - 1);
            cur -= sum[i - 1] - sum[i - n];
            if (cur > ans) {
                ans = cur;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxRotateFunction(new int[]{4, 3, 2, 6}));
        System.out.println(solution.maxRotateFunction(new int[]{100}));
    }
}