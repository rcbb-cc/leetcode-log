package cc.rcbb.leetcode.topic_668;

/**
 * 668. 乘法表中第k小的数
 * https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 */
class Solution {
    /**
     * 乘法表中第k小的数并不能直观地得到。
     * 转换思路：乘法表中的某个数 x，比它小的数有多少个？
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, m, n, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int x, int m, int n, int k) {
        int cnt = x / n * n;
        for (int i = x / n + 1; i <= m; i++) {
            cnt += x / i;
        }
        return cnt >= k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // m = 3, n = 3, k = 5
        System.out.println(solution.findKthNumber(3, 3, 5));
    }

}