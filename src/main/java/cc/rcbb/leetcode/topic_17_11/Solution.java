package cc.rcbb.leetcode.topic_17_11;


/**
 * 面试题 17.11. 单词距离
 * https://leetcode.cn/problems/find-closest-lcci/
 */
class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int p = -1, q = -1;
        int min = words.length;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                p = i;
            } else if (word2.equals(words[i])) {
                q = i;
            }
            if (p != -1 && q != -1) {
                min = Math.min(min, Math.abs(p - q));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
        System.out.println(solution.findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student"));
    }

}