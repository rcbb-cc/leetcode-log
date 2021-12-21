package cc.rcbb.leetcode.topic_1154;

/**
 * 1154. 一年中的第几天
 * https://leetcode-cn.com/problems/day-of-the-year/
 */
class Solution {
    /**
     * 1,3,5,7,8,10,12是31天
     * 其他为30天 2月28天, 闰年29天
     * 什么是闰年？
     * 规则如下： 1、能被4整除，但不能被100整除； 2、能被400整除；
     */
    public int dayOfYear(String date) {
        int count = 0;
        int[] dayArray = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] strArray = date.split("-");
        Integer year = Integer.valueOf(strArray[0]);
        Integer month = Integer.valueOf(strArray[1]);
        Integer day = Integer.valueOf(strArray[2]);
        for (int i = 0; i < month; i++) {
            count += dayArray[i];
        }
        if (isLeapYear(year) && month > 2) {
            count++;
        }
        return count + day;
    }

    /**
     * 闰年分为普通闰年和世纪闰年。
     * 1、普通闰年：公历年份是4的倍数的，且不是100的倍数，为普通闰年。
     * （如2004、2020年就是闰年）；
     * 2、世纪闰年：公历年份是整百数的，必须是400的倍数才是世纪闰年
     * （如1900年不是世纪闰年，2000年是世纪闰年）
     */
    public boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：date = "2019-01-09"
        //输出：9
        System.out.println(solution.dayOfYear("2019-01-09"));
        //输入：date = "2019-02-10"
        //输出：41
        System.out.println(solution.dayOfYear("2019-02-10"));
        //输入：date = "2003-03-01"
        //输出：60
        System.out.println(solution.dayOfYear("2003-03-01"));
        //输入：date = "2004-03-01"
        //输出：61
        System.out.println(solution.dayOfYear("2004-03-01"));
        // 2
        System.out.println(solution.dayOfYear("2012-01-02"));
    }

}