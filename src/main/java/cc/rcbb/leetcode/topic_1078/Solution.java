package cc.rcbb.leetcode.topic_1078;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1078. Bigram 分词
 * https://leetcode-cn.com/problems/occurrences-after-bigram/
 */
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();
        String[] textArray = text.split(" ");
        for (int i = 1; i < textArray.length; i++) {
            if (textArray[i - 1].equals(first) && textArray[i].equals(second)) {
                if (i + 1 < textArray.length) {
                    result.add(textArray[i + 1]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] result = solution.findOcurrences("alice is a good girl she is a good student", "a", "good");
        System.out.println(Arrays.toString(result));
    }

}