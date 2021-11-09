package cc.rcbb.leetcode.topic_1011;

/**
 * 1011. 在 D 天内送达包裹的能力
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class Solution {

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int r = f(weights, mid);
            if (r == -1 || r > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int f(int[] weights, int mid) {
        int day = 1;
        int curW = mid;
        for (int i = 0; i < weights.length; i++) {
            if (mid - weights[i] < 0) {
                return -1;
            }
            if (weights[i] <= curW) {
                curW -= weights[i];
            } else {
                day++;
                i--;
                curW = mid;
            }
        }
        return day;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：weights = [3,2,2,4,1,4], D = 3  输出：6
        int[] weights = {3, 2, 2, 4, 1, 4};
        int d = 3;

        int s = solution.shipWithinDays(weights, d);
        System.out.println(s);
    }
}