package cc.rcbb.leetcode.topic_860;

import java.util.HashMap;
import java.util.Map;

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

    public boolean lemonadeChange1(int[] bills) {
        if (bills[0] != 5) {
            return false;
        }
        Map<Integer, Integer> ownMap = new HashMap<>();
        ownMap.put(5, 1);
        for (int i = 1; i < bills.length; i++) {
            int val = bills[i] - 5;
            if (val == 0) {
                ownMap.put(5, ownMap.get(5) + 1);
            } else if (val == 5) {
                Integer fiveCount = ownMap.get(5);
                if (fiveCount < 1) {
                    return false;
                } else {
                    ownMap.put(5, ownMap.get(5) - 1);
                    ownMap.put(10, ownMap.getOrDefault(10, 0) + 1);
                }
            } else if (val == 15) {
                Integer fiveCount = ownMap.get(5);
                Integer tenCount = ownMap.getOrDefault(10, 0);
                if (tenCount < 1 && fiveCount < 3) {
                    return false;
                } else if (tenCount >= 1 && fiveCount < 1) {
                    return false;
                } else {
                    if (tenCount < 1) {
                        ownMap.put(5, ownMap.get(5) - 3);
                        ownMap.put(20, ownMap.getOrDefault(20, 0) + 1);
                    } else {
                        ownMap.put(10, ownMap.get(10) - 1);
                        ownMap.put(5, ownMap.get(5) - 1);
                    }
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