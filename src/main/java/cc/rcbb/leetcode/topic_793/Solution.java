package cc.rcbb.leetcode.topic_793;

/**
 * 793. 阶乘函数后 K 个零
 * https://leetcode-cn.com/problems/preimage-size-of-factorial-zeroes-function/
 */
class Solution {
    public int preimageSizeFZF(int k) {
        return (int) (help(k + 1) - help(k));
    }

    public long help(int k) {
        long r = 5L * k;
        long l = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (zeta(mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r + 1;
    }

    public long zeta(long x) {
        long res = 0;
        while (x != 0) {
            res += x / 5;
            x /= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.preimageSizeFZF(0));
        System.out.println(solution.preimageSizeFZF(5));
    }
}