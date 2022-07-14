package cc.rcbb.leetcode.topic_745;

import java.util.HashMap;
import java.util.Map;

/**
 * 745. 前缀和后缀搜索
 * https://leetcode.cn/problems/prefix-and-suffix-search/
 */
class WordFilter {

    Map<String, Integer> dict;

    public WordFilter(String[] words) {
        dict = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int m = word.length();
            for (int pre = 1; pre <= m; pre++) {
                for (int suffix = 1; suffix <= m; suffix++) {
                    dict.put(word.substring(0, pre) + "#" + word.substring(m - suffix), i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return dict.getOrDefault(pref + "#" + suff, -1);
    }

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple"});
        System.out.println(wordFilter.f("a", "e"));
    }
}
