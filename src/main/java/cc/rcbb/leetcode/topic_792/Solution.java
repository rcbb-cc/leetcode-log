package cc.rcbb.leetcode.topic_792;

import java.util.ArrayList;
import java.util.List;

/**
 * 792. 匹配子序列的单词数
 * https://leetcode.cn/problems/number-of-matching-subsequences/
 * <p>
 * 二分查找
 */
class Solution {

    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        for (String w : words) {
            if (w.length() > s.length()) {
                res--;
                continue;
            }
            int p = -1;
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (pos[c - 'a'].isEmpty()
                        || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p) {
                    res--;
                    break;
                }
                p = binarySeach(pos[c - 'a'], p);
            }
        }
        return res;
    }

    private int binarySeach(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
        System.out.println(solution.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
    }
}