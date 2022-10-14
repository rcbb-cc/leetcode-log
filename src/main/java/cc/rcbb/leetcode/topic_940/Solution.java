package cc.rcbb.leetcode.topic_940;

/**
 * 940. 不同的子序列 II
 * https://leetcode.cn/problems/distinct-subsequences-ii/
 */
class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int[] g = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int total = 1;
            for (int j = 0; j < 26; j++) {
                total = (total + g[j]) % mod;
            }
            g[s.charAt(i) - 'a'] = total;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = (ans + g[i]) % mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.distinctSubseqII("abc"));
        System.out.println(solution.distinctSubseqII("aba"));
        System.out.println(solution.distinctSubseqII("aaa"));
        System.out.println(solution.distinctSubseqII("pcrdhwdxmqdznbenhwjsenjhvulyve"));
    }
}