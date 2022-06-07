package cc.rcbb.leetcode.topic_875;


/**
 * 875. 爱吃香蕉的珂珂
 * https://leetcode-cn.com/problems/koko-eating-bananas/
 */
public class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        int k = right;
        while (left < right) {
            int speed = left + (right - left) / 2;
            int time = getTime(piles, speed);
            if (time <= h) {
                k = speed;
                right = speed;
            } else {
                left = speed + 1;
            }
        }
        return k;
    }

    public int getTime(int piles[], int speed) {
        int sum = 0;
        for (int pile : piles) {
            int curTime = (pile + speed - 1) / speed;
            sum += curTime;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入: piles = [3,6,7,11], H = 8 输出: 4
        // System.out.println(solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));

        // 输入: piles = [30,11,23,4,20], H = 5 输出: 30
        // System.out.println(solution.minEatingSpeed(new int[]{30,11,23,4,20}, 5));

        // 输入: piles = [30,11,23,4,20], H = 6 输出: 23
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));

    }
}