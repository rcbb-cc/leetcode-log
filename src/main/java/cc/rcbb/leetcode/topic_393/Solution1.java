package cc.rcbb.leetcode.topic_393;

/**
 * 393. UTF-8 编码验证
 * https://leetcode-cn.com/problems/utf-8-validation/
 */
class Solution1 {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; ) {
            int temp = data[i];
            int bit = 7;
            if (temp < 128) {
                i++;
                continue;
            }
            if (temp >= 248 || temp < 192) {
                return false;
            }
            while (bit >= 0 && ((((temp >> bit) & 1) == 1))) {
                bit--;
            }
            int head = 7 - bit;
            if (i + head - 1 >= n) {
                return false;
            }
            temp = head;
            while (--temp > 0) {
                if (128 <= data[i + temp] && data[i + temp] < 192) {
                    continue;
                }
                return false;
            }
            i += head;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.validUtf8(new int[]{197, 130, 1}));
        System.out.println(solution.validUtf8(new int[]{235, 140, 4}));
        System.out.println(solution.validUtf8(new int[]{255}));
        System.out.println(solution.validUtf8(new int[]{10}));

    }
}