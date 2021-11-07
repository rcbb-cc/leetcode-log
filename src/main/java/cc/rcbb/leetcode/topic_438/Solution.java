package cc.rcbb.leetcode.topic_438;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        char[] pArray = p.toCharArray();
        for (int i = 0; i < pArray.length; i++) {
            need.put(pArray[i], need.getOrDefault(pArray[i], 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;


        return null;
    }
}