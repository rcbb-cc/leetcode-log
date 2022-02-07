package cc.rcbb.leetcode.topic_860;

/**
 * 860. 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/
 */
class Solution {

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else if (bill == 20) {
                if (five > 0 && ten > 0) {
                    // 首先尝试 10+5 的方案
                    five--;
                    ten--;
                } else if (five >= 3) {
                    // 不行在尝试 5+5+5 的方案
                    five -= 3;
                } else {
                    // 没方案了
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] bills = new int[]{5,5,5,10,20};
        //int[] bills = new int[]{5, 5, 10, 10, 20};
        int[] bills = new int[]{5, 5, 5, 5, 20, 20, 5, 5, 20, 5};
        System.out.println(solution.lemonadeChange(bills));
    }
}