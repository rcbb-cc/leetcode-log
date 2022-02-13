package cc.rcbb.leetcode.topic_1189;

import java.util.HashMap;
import java.util.Map;

/**
 * 1189. “气球” 的最大数量
 * https://leetcode-cn.com/problems/maximum-number-of-balloons/
 */
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[5];
        char[] chars = text.toCharArray();
        for (char c : chars) {
            if (c == 'a') {
                arr[0]++;
            } else if (c == 'b') {
                arr[1]++;
            } else if (c == 'l') {
                arr[2]++;
            } else if (c == 'n') {
                arr[3]++;
            } else if (c == 'o') {
                arr[4]++;
            }
        }
        arr[2] /= 2;
        arr[4] /= 2;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            count = Math.min(count, arr[i]);
        }
        return count;
    }

    public int maxNumberOfBalloons1(String text) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = text.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        char[] baseChars = "balloon".toCharArray();
        while (true) {
            boolean flag = false;
            for (char c : baseChars) {
                if (map.get(c) == null || map.get(c) == 0) {
                    flag = true;
                    break;
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
            if (flag) {
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxNumberOfBalloons("nlaebolko"));
        System.out.println(solution.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(solution.maxNumberOfBalloons("leetcode"));
    }
}