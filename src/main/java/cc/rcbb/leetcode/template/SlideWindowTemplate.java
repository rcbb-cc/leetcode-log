package cc.rcbb.leetcode.template;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口解题模板
 */
public class SlideWindowTemplate {

    void slidingWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        char[] tArray = t.toCharArray();
        for (int i = 0; i < tArray.length; i++) {
            need.put(tArray[i], need.getOrDefault(tArray[i], 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        char[] sArray = s.toCharArray();
        while (right < s.length()) {
            // c是将移入窗口的字符
            char c = sArray[right];
            // 右移窗口
            right++;

            // 进行窗口内数据的一系列更新
            /**
             * 1.当移动right扩大窗口，即加入字符时，应该更新哪些数据？
             */

            System.out.println(String.format("window [%s,%s)", left, right));

            /**
             * 2.什么条件下，窗口应该暂停扩大，开始移动left缩小窗口？
             */
            // 判断左侧窗口是否要收缩
            if (valid == need.size()) {
                // d是将移出窗口的字符
                char d = sArray[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                /**
                 * 3.当移动left缩小窗口，即移出字符时，应该更新哪些数据？
                 */

            }
            /**
             * 4.我们要的结果 应该在扩大窗口时还是缩小窗口时进行更新。
             */
        }


    }

}
