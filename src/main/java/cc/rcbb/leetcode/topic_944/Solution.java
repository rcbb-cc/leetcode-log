package cc.rcbb.leetcode.topic_944;

/**
 * 944. 删列造序
 * https://leetcode.cn/problems/delete-columns-to-make-sorted/
 */
class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int m = strs.length;
        int n = strs[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = 0, cur = -1; j < m; j++) {
                int c = strs[j].charAt(i);
                if (cur > c) {
                    count++;
                    break;
                }
                cur = c;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：strs = ["cba","daf","ghi"]
        // 输出：1
        System.out.println(solution.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        // 输入：strs = ["a","b"]
        // 输出：0
        System.out.println(solution.minDeletionSize(new String[]{"a", "b"}));

        // 输入：strs = ["zyx","wvu","tsr"]
        // 输出：3
        System.out.println(solution.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
        // ["cekjd","ihpzr","zvzzx"]
        System.out.println(solution.minDeletionSize(new String[]{"cekjd", "ihpzr", "zvzzx"}));
    }
}