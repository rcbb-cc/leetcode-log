package cc.rcbb.leetcode.topic_1994;

/**
 * 1994. 好子集的数目
 * https://leetcode-cn.com/problems/the-number-of-good-subsets/
 */
class Solution {
    int MOD = (int) 1e9 + 7;
    int[] p = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    int[] cnts = new int[35];

    public int numberOfGoodSubsets(int[] nums) {
        int n = nums.length;
        for (int i : nums) {
            cnts[i]++;
        }
        int mask = 1 << 10;
        long[] f = new long[mask];
        f[0] = 1;
        for (int i = 2; i <= 30; i++) {
            if (cnts[i] == 0) {
                continue;
            }
            int cur = 0;
            int x = i;
            boolean ok = true;
            for (int j = 0; j < 10; j++) {
                int t = p[j];
                int c = 0;
                while (x % t == 0) {
                    cur |= (1 << j);
                    x /= t;
                    c++;
                }
                if (c > 1) {
                    ok = false;
                    break;
                }
            }
            if (!ok) {
                continue;
            }
            for (int prev = mask - 1; prev >= 0; prev--) {
                if ((prev & cur) != 0) {
                    continue;
                }
                f[prev | cur] = (f[prev | cur] + f[prev] * cnts[i]) % MOD;
            }
        }
        long ans = 0;
        for (int i = 1; i < mask; i++) {
            ans = (ans + f[i]) % MOD;
        }
        for (int i = 0; i < cnts[1]; i++) {
            ans = ans * 2 % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        //System.out.println(solution.numberOfGoodSubsets(new int[]{1, 2, 3, 4}));
        System.out.println(solution.numberOfGoodSubsets(new int[]{4, 2, 3, 15}));
    }
}