package cc.rcbb.leetcode.topic_686;

/**
 * 686. 重复叠加字符串匹配
 * https://leetcode-cn.com/problems/repeated-string-match/
 */
class Solution {
    public int repeatedStringMatch(String a, String b) {
        // 如果b里面有a不存在的字符，直接返回-1
        boolean[] arr = new boolean[26];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < b.length(); i++) {
            if (!arr[b.charAt(i) - 'a']) {
                return -1;
            }
        }

        int count = b.length() / a.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(a);
        }
        // StringBuilder sb = new StringBuilder(a.repeat(count));
        for (int i = 0; i <= 2; i++) {
            if (sb.indexOf(b) >= 0) {
                return count + i;
            }
            sb.append(a);
        }

        return -1;
    }

}