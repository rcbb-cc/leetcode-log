package cc.rcbb.leetcode.topic_682;

import java.util.LinkedList;

/**
 * 682. 棒球比赛
 * https://leetcode-cn.com/problems/baseball-game/
 */
class Solution {
    public int calPoints(String[] ops) {
        int n = ops.length;
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String op = ops[i];
            if ("+".equals(op)) {
                int t = list.get(list.size() - 1) + list.get(list.size() - 2);
                sum += t;
                list.add(t);
            } else if ("D".equals(op)) {
                Integer last = list.getLast();
                sum += last * 2;
                list.add(last * 2);
            } else if ("C".equals(op)) {
                Integer last = list.removeLast();
                sum -= last;
            } else {
                Integer t = Integer.valueOf(op);
                list.add(t);
                sum += t;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(solution.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
        System.out.println(solution.calPoints(new String[]{"1"}));
        //["36","28","70","65","C","+","33","-46","84","C"]
        //预期结果： 219
        System.out.println(solution.calPoints(new String[]{"36", "28", "70", "65", "C", "+", "33", "-46", "84", "C"}));
    }
}