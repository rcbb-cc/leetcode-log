package cc.rcbb.leetcode.topic_393;

/**
 * 393. UTF-8 编码验证
 * https://leetcode-cn.com/problems/utf-8-validation/
 */
class Solution {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; ) {
            int t = data[i];
            int j = 7;
            // 先统计 data[i]data[i] 从第 7 位开始往后有多少位连续的 1
            while (j >= 0 && ((t >> j) & 1) == 1) {
                j--;
            }
            int cnt = 7 - j;
            // 如果 cnt 为 1 或者大于 4 均违反编码规则
            if (cnt == 1 || cnt > 4) {
                return false;
            }
            // 如果位置 ii 后面不足 cnt - 1cnt−1
            if (i + cnt - 1 >= n) {
                return false;
            }
            for (int k = i + 1; k < i + cnt; k++) {
                if ((((data[k] >> 7) & 1) == 1) &&
                        (((data[k] >> 6) & 1) == 0)) {
                    continue;
                }
                return false;

            }
            if (cnt == 0) {
                i++;
            } else {
                i += cnt;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.validUtf8(new int[]{197, 130, 1}));
        //System.out.println(solution.validUtf8(new int[]{235, 140, 4}));
        //System.out.println(solution.validUtf8(new int[]{255}));
        //System.out.println(solution.validUtf8(new int[]{10}));
        System.out.println(solution.validUtf8(new int[]{240, 162, 138, 147, 145}));
    }
}