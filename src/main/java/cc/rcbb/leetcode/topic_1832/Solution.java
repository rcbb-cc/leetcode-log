package cc.rcbb.leetcode.topic_1832;

/**
 * 1832. 判断句子是否为全字母句
 * https://leetcode.cn/problems/check-if-the-sentence-is-pangram/
 * <p>
 * 模拟
 */
class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] visit = new boolean[26];
        for (int i = 0; i < sentence.length(); i++) {
            visit[sentence.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < 26; i++) {
            if (visit[i] == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(solution.checkIfPangram("leetcode"));
    }
}