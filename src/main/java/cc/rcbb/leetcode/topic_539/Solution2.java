package cc.rcbb.leetcode.topic_539;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 539. 最小时间差
 * https://leetcode-cn.com/problems/minimum-time-difference/
 */
class Solution2 {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        // 必然有两个相同时间点
        if (n >= 1440) {
            return 0;
        }
        int[] cnts = new int[1440 * 2 + 10];
        for (String s : timePoints) {
            String[] timeArray = s.split(":");
            int h = Integer.parseInt(timeArray[0]);
            int m = Integer.parseInt(timeArray[1]);
            cnts[h * 60 + m]++;
            cnts[h * 60 + m + 1440]++;
        }
        int ans = 1440;
        int last = -1;
        for (int i = 0; i <= 1440 * 2 && ans != 0; i++) {
            if (cnts[i] == 0) {
                continue;
            }
            // 存在重复点
            if (cnts[i] > 1) {
                ans = 0;
            } else if (last != -1) {
                ans = Math.min(ans, i - last);
            }
            last = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

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