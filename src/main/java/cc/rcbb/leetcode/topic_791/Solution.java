package cc.rcbb.leetcode.topic_791;

import java.util.Arrays;

/**
 * 791. 自定义字符串排序
 * https://leetcode.cn/problems/custom-sort-string/
 * <p>
 * 模拟
 */
class Solution {
    public String customSortString(String order, String s) {
        int[] val = new int[26];
        for (int i = 0; i < order.length(); i++) {
            val[order.charAt(i) - 'a'] = i + 1;
        }
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, (c0, c1) -> val[c0 - 'a'] - val[c1 - 'a']);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            ans.append(arr[i]);
        }
        return ans.toString();
    }

    public String customSortString1(String order, String s) {
        char[] array = s.toCharArray();
        boolean[] visit = new boolean[array.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            for (int j = 0; j < array.length; j++) {
                if (visit[j] == false && c == array[j]) {
                    sb.append(c);
                    visit[j] = true;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (visit[i] == false) {
                sb.append(array[i]);
                visit[i] = true;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.customSortString("cba", "abcd"));
        System.out.println(solution.customSortString("cbafg", "abcd"));
    }
}