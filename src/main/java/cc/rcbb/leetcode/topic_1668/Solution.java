package cc.rcbb.leetcode.topic_1668;

/**
 * 1668. 最大重复子字符串
 * https://leetcode.cn/problems/maximum-repeating-substring/
 * <p>
 * 模拟
 */
class Solution {
    public int maxRepeating(String sequence, String word) {
        int max = sequence.length() / word.length();
        int count = 0;
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < max; i++) {
            if (!sequence.contains(sb.toString())) {
                break;
            }
            count++;
            sb.append(word);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxRepeating("ababc", "ab"));
        System.out.println(solution.maxRepeating("ababc", "ba"));
        System.out.println(solution.maxRepeating("ababc", "ac"));
    }
}