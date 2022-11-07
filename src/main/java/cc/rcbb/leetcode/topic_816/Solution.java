package cc.rcbb.leetcode.topic_816;


import java.util.ArrayList;
import java.util.List;

/**
 * 816. 模糊坐标
 * https://leetcode.cn/problems/ambiguous-coordinates/
 * <p>
 * 模拟
 */
class Solution {
    public List<String> ambiguousCoordinates(String s) {
        int n = s.length() - 1;
        List<String> res = new ArrayList<>();
        // 去掉括号
        s = s.substring(1, s.length() - 1);
        for (int i = 1; i < n; i++) {
            // 左边部分
            List<String> lt = getPos(s.substring(0, i));
            if (lt.isEmpty()) {
                continue;
            }
            // 右边部分
            List<String> rt = getPos(s.substring(i));
            if (lt.isEmpty()) {
                continue;
            }
            for (String sl : lt) {
                for (String sr : rt) {
                    res.add("(" + sl + ", " + sr + ")");
                }
            }
        }
        return res;
    }

    public List<String> getPos(String s) {
        List<String> pos = new ArrayList<>();
        if ("".equals(s)) {
            return pos;
        }
        // 如果首个字符不是 0，或者整个字符就是 0，直接加入结果
        if (s.charAt(0) != '0' || "0".equals(s)) {
            pos.add(s);
        }
        for (int p = 1; p < s.length(); p++) {
            // 不添加小数点和添小数点后的整数部分都需要满足当前表示数字为 0 或者为不含前导零的正数
            if ((p != 1 && s.charAt(0) == '0')
                    // 添加小数点后，小数部分需要满足其末尾不为 0
                    || s.charAt(s.length() - 1) == '0') {
                continue;
            }
            pos.add(s.substring(0, p) + "." + s.substring(p));
        }
        return pos;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.ambiguousCoordinates("(123)"));
        System.out.println(solution.ambiguousCoordinates("(00011)"));
        System.out.println(solution.ambiguousCoordinates("(0123)"));
        System.out.println(solution.ambiguousCoordinates("(100+)"));
    }
}