package cc.rcbb.leetcode.topic_676;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 676. 实现一个魔法字典
 * https://leetcode.cn/problems/implement-magic-dictionary/
 */
class MagicDictionary {

    private Map<Integer, List<String>> map;

    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String str : dictionary) {
            Integer key = str.length();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
    }

    public boolean search(String searchWord) {
        Integer key = searchWord.length();
        if (map.containsKey(key)) {
            List<String> list = map.get(key);
            for (String str : list) {
                if (check(searchWord, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        if (count == 1) {
            return true;
        }
        return false;
    }
}
