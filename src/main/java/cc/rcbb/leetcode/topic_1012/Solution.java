package cc.rcbb.leetcode.topic_1012;

import java.util.ArrayList;
import java.util.List;

/**
 * 1012. 至少有 1 位重复的数字
 * https://leetcode.cn/problems/numbers-with-repeated-digits/
 */
class Solution {
    public int numDupDigitsAtMostN(int n) {
        return (n + 1) - dp(n);
    }

    static int[][] f = new int[10][10];

    static {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                int cur = 1;
                for (int k = i; k <= j; k++) {
                    cur *= k;
                }
                f[i][j] = cur;
            }
        }
    }

    int dp(int x) {
        int t = x;
        List<Integer> nums = new ArrayList<>();
        while (t != 0) {
            nums.add(t % 10);
            t /= 10;
        }
        int n = nums.size();
        if (n <= 1) {
            return x + 1;
        }
        int ans = 0;
        for (int i = n - 1, p = 1, s = 0; i >= 0; i--, p++) {
            int cur = nums.get(i), cnt = 0;
            for (int j = cur - 1; j >= 0; j--) {
                if (i == n - 1 && j == 0) {
                    continue;
                }
                if (((s >> j) & 1) == 0) {
                    cnt++;
                }
            }
            int a = 10 - p, b = a - (n - p) + 1;
            ans += b <= a ? cnt * f[b][a] : cnt;
            if (((s >> cur) & 1) == 1) {
                break;
            }
            s |= (1 << cur);
            if (i == 0) {
                ans++;
            }
        }
        ans += 10;
        for (int i = 2, last = 9; i < n; i++) {
            int cur = last * (10 - i + 1);
            ans += cur;
            last = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDupDigitsAtMostN(20));
        System.out.println(solution.numDupDigitsAtMostN(100));
        System.out.println(solution.numDupDigitsAtMostN(1000));
    }

}