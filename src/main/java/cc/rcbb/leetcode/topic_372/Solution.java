package cc.rcbb.leetcode.topic_372;

/**
 * 372. 超级次方
 * https://leetcode-cn.com/problems/super-pow/
 */
class Solution {
    int mod = 1337;

    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    int dfs(int a, int[] b, int u) {
        if (u == -1) {
            return 1;
        }
        return qpow(dfs(a, b, u - 1), 10) * qpow(a, b[u]) % mod;
    }

    int qpow(int a, int b) {
        int res = 1;
        a = a % mod;
        while (b != 0) {
            if ((b & 1) != 0) {
                // 奇数
                res = res * a % mod;
            }
            a = a * a % mod;
            b = b >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.superPow(2, new int[]{3}));
        System.out.println(solution.superPow(2, new int[]{1, 0}));
        System.out.println(solution.superPow(1, new int[]{4, 3, 3, 8, 5, 2}));
        System.out.println(solution.superPow(2147483647, new int[]{2, 0, 0}));
    }

}