package cc.rcbb.leetcode.topic_6;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) {
            res.append(sb);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //输入：s = "PAYPALISHIRING", numRows = 3
        //输出："PAHNAPLSIIGYIR"
        System.out.println(solution.convert("PAYPALISHIRING", 3));
        //输入：s = "PAYPALISHIRING", numRows = 4
        //输出："PINALSIGYAHRPI"
        System.out.println(solution.convert("PAYPALISHIRING", 4));
    }

}