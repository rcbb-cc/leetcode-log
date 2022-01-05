package cc.rcbb.leetcode.topic_1576;

/**
 * 1576. 替换所有的问号
 * https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 */
class Solution {

    /**
     * 根据题意进行模拟，尝试对每个 s[i] 进行替换，
     * 能够替换的前提是 s[i]为 ?，
     * 且替换字符与前后字符（若存在）不同，
     * 由于只需要确保与前后字符不同，因此必然最多在 3个字符内找到可替换的值。
     */
    public String modifyString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            if (cs[i] == '?') {
                for (int c = 0; c < 3; c++) {
                    boolean ok = true;
                    if (i - 1 >= 0 &&
                            cs[i - 1] == c + 'a') {
                        ok = false;
                    }
                    if (i + 1 < n &&
                            cs[i + 1] == c + 'a') {
                        ok = false;
                    }
                    if (ok) {
                        cs[i] = (char) (c + 'a');
                    }
                }
            }
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        // a?b
        // ???
        // a??
        // a??c
        // a??b?c

        //System.out.println('a' - '0');
        //System.out.println('a');
        //System.out.println((char) ('a' + 1));

        Solution solution = new Solution();
        System.out.println(solution.modifyString("?"));
        System.out.println(solution.modifyString("a?b"));
        System.out.println(solution.modifyString("???"));
        System.out.println(solution.modifyString("a??"));
        System.out.println(solution.modifyString("a??b?c"));
        System.out.println(solution.modifyString("a????????????????????????????????????????????????????????????????????????????????????????????????????b"));
    }

}