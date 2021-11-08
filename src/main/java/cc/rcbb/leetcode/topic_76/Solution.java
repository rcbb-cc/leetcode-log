package cc.rcbb.leetcode.topic_76;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class Solution {

    public String minWindow(String s, String t) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        char[] tArray = t.toCharArray();
        for (int i = 0; i < tArray.length; i++) {
            need.put(tArray[i], need.getOrDefault(tArray[i], 0) + 1);
        }

        char[] sArray = s.toCharArray();

        int left = 0;
        int right = 0;
        int valid = 0;

        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < sArray.length) {
            char c = sArray[right];
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = sArray[left];
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public String minWindow1(String s, String t) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        char[] tArray = t.toCharArray();
        for (int i = 0; i < tArray.length; i++) {
            need.put(tArray[i], need.getOrDefault(tArray[i], 0) + 1);
        }

        char[] sArray = s.toCharArray();

        int left = 0;
        int right = 0;
        int valid = 0;

        // 记录最小覆盖子串的其实索引及长度
        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < sArray.length) {
            // c是将移入窗口的字符
            char c = sArray[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    System.out.println(String.format("window.get(c) == need.get(c)", valid));
                    valid++;
                }
            }

            System.out.println(String.format("window: [%s, %s) valid:%s == need.size:%s", left, right, valid, need.size()));

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d是将移出窗口的字符
                char d = sArray[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
                System.out.println(String.format("缩小window: [%s, %s)", start, len));
            }

        }
        // 返回最小覆盖子串
        System.out.println(String.format("result: [%s, %s)", start, len));
        System.out.println(len);
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        //String s = "RBBANCF";
        //String t = "ABC";

        // 输入：s = "ADOBECODEBANC", t = "ABC" 输出："BANC"
        //String s = "ADOBECODEBANC";
        //String t = "ABC";

        //String s = "a";
        //String t = "a";

        String s = "a";
        String t = "aa";

        String r = solution.minWindow(s, t);
        System.out.println(r);


    }
}