package cc.rcbb.leetcode.topic_793;

/**
 * 793. 阶乘函数后 K 个零
 * https://leetcode-cn.com/problems/preimage-size-of-factorial-zeroes-function/
 */
class Solution {
    public int preimageSizeFZF(int k) {
        return (int) (rightBound(k) - leftBound(k) + 1);
    }

    private long leftBound(int target) {
        long lo = 0;
        long hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else if (trailingZeroes(mid) == target) {
                hi = mid;
            }
        }
        return lo;
    }

    private long rightBound(int target) {
        long lo = 0;
        long hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else if (trailingZeroes(mid) == target) {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }

    private long trailingZeroes(long n) {
        long res = 0;
        for (long d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.preimageSizeFZF(0));
        System.out.println(solution.preimageSizeFZF(5));
    }
}