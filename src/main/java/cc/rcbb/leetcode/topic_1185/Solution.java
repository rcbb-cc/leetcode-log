package cc.rcbb.leetcode.topic_1185;

/**
 * 1185. 一周中的第几天
 * https://leetcode-cn.com/problems/day-of-the-week/
 */
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        // 日期范围在 1971-2100
        // 1970-12-31 是星期四
        int res = 4;
        // 计算输入日期间隔，1971 共有多少天
        for (int i = 1971; i < year; i++) {
            if ((i % 400 == 0) || (i % 4 == 0 && i % 100 != 0)) {
                // 闰年 366天
                res += 366;
            } else {
                // 非闰年 366天
                res += 365;
            }
        }
        int[] dayArray = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month; i++) {
            res += dayArray[i];
        }
        // 月份大于2 并且 是闰年，需要加1天
        if (month > 2 &&
                ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))) {
            res++;
        }
        res += day;
        return week[res % 7];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dayOfTheWeek(1, 1, 1971));
        System.out.println(solution.dayOfTheWeek(3, 1, 2022));
        System.out.println(solution.dayOfTheWeek(31, 8, 2019));
        System.out.println(solution.dayOfTheWeek(18, 7, 1999));
        System.out.println(solution.dayOfTheWeek(15, 8, 1993));
    }
}