package cc.rcbb.leetcode.topic_846;

import java.util.Arrays;

/**
 * 846. 一手顺子
 * https://leetcode-cn.com/problems/hand-of-straights/
 */
class Solution {
    /**
     * 1.先对原数组升序排序；
     * 2.进行双指针嵌套遍历；
     * 3.外层遍历找顺子起点，内层遍历找顺子后续元素；
     * 4.被找到的元素置为-1;
     * 5.若无法找到完整顺子则返回false;
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        Arrays.sort(hand);
        for (int i = 0; i < n; i++) {
            if (hand[i] < 0) {
                continue;
            }
            int count = 0;
            for (int j = i + 1; j < n && count != groupSize - 1; j++) {
                if (hand[j] - hand[i] == count + 1) {
                    count++;
                    hand[j] = -1;
                }
            }
            if (count != groupSize - 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
        //输出：true
        //解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
        System.out.println(solution.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        //输入：hand = [1,2,3,4,5], groupSize = 4
        //输出：false
        //解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
        System.out.println(solution.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
        System.out.println(solution.isNStraightHand(new int[]{1}, 1));
        System.out.println(solution.isNStraightHand(new int[]{2, 1}, 2));
        System.out.println(solution.isNStraightHand(new int[]{2, 1}, 2));
        System.out.println(solution.isNStraightHand(new int[]{8,10,12}, 3));
    }


}