package cc.rcbb.leetcode.topic_539;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 539. 最小时间差
 * https://leetcode-cn.com/problems/minimum-time-difference/
 */
class Solution1 {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        Integer min = 1440;
        int pre = get(timePoints.get(0));
        for (int i = 1; i < timePoints.size(); i++) {
            int t = get(timePoints.get(i));
            min = Math.min(min, t - pre);
            pre = t;
        }
        min = Math.min(min, 1440 + get(timePoints.get(0)) - pre);
        return min;
    }

    public int get(String time) {
        String[] timeArray = time.split(":");
        return Integer.valueOf(timeArray[0]) * 60 + Integer.valueOf(timeArray[1]);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        //输入：timePoints = ["23:59","00:00"]
        //输出：1
        System.out.println(solution.findMinDifference(new ArrayList<>(Arrays.asList("23:59", "00:00"))));

        //输入：timePoints = ["00:00","23:59","00:00"]
        //输出：0
        System.out.println(solution.findMinDifference(new ArrayList<>(Arrays.asList("00:00", "23:59", "00:00"))));
        //System.out.println(solution.findMinDifference(new ArrayList<>(Arrays.asList("01:00", "23:59", "02:00"))));
        //System.out.println(solution.findMinDifference(new ArrayList<>(Arrays.asList("01:20", "23:49", "03:00","14:00", "13:00"))));
        System.out.println(solution.findMinDifference(new ArrayList<>(Arrays.asList("01:20", "23:59", "03:00", "11:00", "13:00"))));
        System.out.println(solution.findMinDifference(new ArrayList<>(Arrays.asList("01:20", "23:59"))));

    }
}