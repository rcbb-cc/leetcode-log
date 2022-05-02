package cc.rcbb.leetcode.topic_591;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 591. 标签验证器
 * https://leetcode-cn.com/problems/tag-validator/
 */
class Solution {

    // 1.代码必须被合法的闭合标签包围
    // 2.闭合标签 <></>
    // 3.仅大写字母，长度[1,9]
    // 4.标签中的内容可以包含合法的闭合标签、cdata和任意字符
    // 5.一个起始标签，必须有对应的结束标签
    // 6.一个 < 必须找到后续的 > ，并且中间的内容应该解析的标签名
    // 7.<![CDATA[xxx]]> xxx可以为任意字符，不受检查
    public boolean isValid(String code) {
        Deque<String> tags = new ArrayDeque<>();
        int n = code.length();
        int i = 0;
        while (i < n) {
            if (code.charAt(i) == '<') {
                if (i == n - 1) {
                    return false;
                }
                // 若是 /，则代表是结束标签
                if (code.charAt(i + 1) == '/') {
                    if (tags.isEmpty()) {
                        return false;
                    }
                    // 寻找 >
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    // 取出名称
                    String tagName = code.substring(i + 2, j);
                    if (!tags.peek().equals(tagName)) {
                        return false;
                    }
                    tags.pop();
                    i = j + 1;
                    // 如果标签集合内为空了，但是i并不等于n，则代表标签对外还有内容
                    if (tags.isEmpty() && i != n) {
                        return false;
                    }
                } else if (code.charAt(i + 1) == '!') {
                    // CDATA内容必须存在于标签对中
                    if (tags.isEmpty()) {
                        return false;
                    }
                    // 判断是否与 [CDATA[ 一致
                    if (i + 9 > n) {
                        return false;
                    }
                    String cdata = code.substring(i + 2, i + 9);
                    if (!"[CDATA[".equals(cdata)) {
                        return false;
                    }
                    // 找出结束的位置
                    int j = code.indexOf("]]>", i);
                    if (j < 0) {
                        return false;
                    }
                    i = j + 1;
                } else {
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    String tagName = code.substring(i + 1, j);
                    // 判断长度
                    if (tagName.length() < 1 || tagName.length() > 9) {
                        return false;
                    }
                    // 判断是否为大写字符
                    for (int k = 0; k < tagName.length(); k++) {
                        if (!Character.isUpperCase(tagName.charAt(k))) {
                            return false;
                        }
                    }
                    tags.push(tagName);
                    i = j + 1;
                }
            } else {
                if (tags.isEmpty()) {
                    return false;
                }
                i++;
            }
        }
        return tags.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("<DIV>This is the first line <![CDATA[<div>]]><DIV>"));
        System.out.println(solution.isValid("</A></A></A></A>"));
    }
}