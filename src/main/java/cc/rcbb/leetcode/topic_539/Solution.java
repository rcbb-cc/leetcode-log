package cc.rcbb.leetcode.topic_539;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 539. 最小时间差
 * https://leetcode-cn.com/problems/minimum-time-difference/
 */
class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<String> list = timePoints.stream().sorted().collect(Collectors.toList());
        int min = get(list.get(0), list.get(list.size() - 1));
        for (int i = 1; i < list.size(); i++) {
            int t = get(list.get(i - 1), list.get(i));
            if (t <= min) {
                System.out.println("startTime=" + list.get(i - 1) + " endTime=" + list.get(i));
                min = t;
            }
        }
        return min;
    }

    public int get(String startTime, String endTime) {
        String[] endArray = endTime.split(":");
        String[] startArray = startTime.split(":");
        int hour = Integer.parseInt(endArray[0]) - Integer.parseInt(startArray[0]);
        int min = Integer.parseInt(endArray[1]) - Integer.parseInt(startArray[1]);
        int t = hour * 60 + min;
        if (1440 - t < t) {
            return 1440 - t;
        }
        return t;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //输入：timePoints = ["23:59","00:00"]
        //输出：1
        System.out.println(solution.findMinDifference(new ArrayList<>(Arrays.asList("23:59", "00:00"))));

        //输入：timePoints = ["00:00","23:59","00:00"]
        //输出：0
        System.out.println(solution.findMinDifference(new ArrayList<>(Arrays.asList("00:00", "23:59", "00:00"))));
        //System.out.println(solution.findMinDifference(new ArrayList<>(Arrays.asList("01:00", "23:59", "02:00"))));
        //System.out.println(solution.findMinDifference(new ArrayList<>(Arrays.asList("01:20", "23:49", "03:00","14:00", "13:00"))));
        System.out.println(solution.findMinDifference(new ArrayList<>(Arrays.asList("01:20", "23:59", "03:00","11:00", "13:00"))));
        System.out.println(solution.findMinDifference(new ArrayList<>(Arrays.asList("01:20", "23:59"))));

    }
}