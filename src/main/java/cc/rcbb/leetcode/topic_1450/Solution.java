package cc.rcbb.leetcode.topic_1450;

/**
 * 1450. 在既定时间做作业的学生人数
 * https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/
 */
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                count++;
            }
        }
        return count;
    }
}