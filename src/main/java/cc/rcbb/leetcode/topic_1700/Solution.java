package cc.rcbb.leetcode.topic_1700;

import java.util.Arrays;

/**
 * 1700. 无法吃午餐的学生数量
 * https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/
 * <p>
 * 模拟
 */
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // 喜欢吃方形
        int s1 = Arrays.stream(students).sum();
        // 喜欢吃圆形
        int s0 = students.length - s1;
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            } else if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
    }
}