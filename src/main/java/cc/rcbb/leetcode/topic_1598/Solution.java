package cc.rcbb.leetcode.topic_1598;

/**
 * 1598. 文件夹操作日志搜集器
 * https://leetcode.cn/problems/crawler-log-folder/
 */
class Solution {
    public int minOperations(String[] logs) {
        int step = 0;
        for (String str : logs) {
            if ("../".equals(str)) {
                step--;
                step = step < 0 ? 0 : step;
            } else if ("./".equals(str)) {

            } else {
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
        System.out.println(solution.minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        System.out.println(solution.minOperations(new String[]{"d1/", "../", "../", "../"}));
        System.out.println(solution.minOperations(new String[]{"./", "wz4/", "../", "mj2/", "../", "../", "ik0/", "il7/"}));
    }
}