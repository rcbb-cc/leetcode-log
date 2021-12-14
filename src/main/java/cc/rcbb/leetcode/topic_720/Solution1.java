package cc.rcbb.leetcode.topic_720;

/**
 * 720. 词典中最长的单词
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/
 */
class Solution1 {
    public String longestWord(String[] words) {
        TireTree tree = new TireTree();
        for (int i = 0; i < words.length; i++) {
            tree.addWorld(words[i]);
        }
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (tree.isValid(words[i])) {
                if (result.length() < words[i].length()) {
                    result = words[i];
                } else if (result.length() == words[i].length()) {
                    if (result.compareTo(words[i]) > 0) {
                        result = words[i];
                    }
                }
            }
        }
        return result;
    }

    class TireTree {
        private TireNode root = new TireNode();

        class TireNode {
            private boolean isEnd;
            TireNode[] links = new TireNode[26];

            public boolean isEnd() {
                return isEnd;
            }
        }

        public void addWorld(String word) {
            TireNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.links[c - 'a'] == null) {
                    cur.links[c - 'a'] = new TireNode();
                }
                cur = cur.links[c - 'a'];
                if (i == word.length() - 1) {
                    cur.isEnd = true;
                }
            }
        }

        public boolean isValid(String word) {
            TireNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.links[c - 'a'] == null) {
                    return false;
                } else if (!cur.links[c - 'a'].isEnd) {
                    return false;
                }
                cur = cur.links[c - 'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
}