package cc.rcbb.leetcode.topic_824;

import java.util.HashSet;
import java.util.Set;

/**
 * 824. 山羊拉丁文
 * https://leetcode-cn.com/problems/goat-latin/
 */
class Solution {
    public String toGoatLatin(String sentence) {
        int n = sentence.length();
        String last = "a";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && sentence.charAt(j) != ' ') {
                j++;
            }
            if ("aeiouAEIOU".indexOf(sentence.charAt(i)) >= 0) {
                sb.append(sentence.substring(i, j)).append("ma");
            } else {
                sb.append(sentence.substring(i + 1, j)).append(sentence.charAt(i)).append("ma");
            }
            sb.append(last);
            last += "a";
            i = j + 1;
            if (i < n) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String toGoatLatin1(String sentence) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        int n = sentence.length();
        int i = 0;
        int index = 1;
        // 用于标记
        boolean first = true;
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        char firstC = ' ';
        while (i <= n) {
            // 是第一个字母
            if (i < n && first) {
                char c = sentence.charAt(i);
                if (set.contains(c)) {
                    // 元音，到最后添加 ma
                    flag = true;
                    sb.append(c);
                } else {
                    // 非元音，移到最后，然后添加 ma
                    flag = false;
                    firstC = c;
                }
                first = false;
            } else {
                if (i == n || sentence.charAt(i) == ' ') {
                    if (flag) {
                        sb.append("ma");
                    } else {
                        sb.append(firstC);
                        sb.append("ma");
                    }
                    for (int j = 1; j <= index; j++) {
                        sb.append('a');
                    }
                    first = true;
                    index++;
                }
                if (i < n) {
                    sb.append(sentence.charAt(i));
                }
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：sentence = "I speak Goat Latin"
        // 输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
        System.out.println(solution.toGoatLatin("I speak Goat Latin"));
        // 输入：sentence = "The quick brown fox jumped over the lazy dog"
        // 输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
        System.out.println(solution.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}