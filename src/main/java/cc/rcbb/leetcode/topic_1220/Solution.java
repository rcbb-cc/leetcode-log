package cc.rcbb.leetcode.topic_1220;


import java.util.Arrays;

/**
 * 1220. 统计元音字母序列的数目
 * https://leetcode-cn.com/problems/count-vowels-permutation/
 */
class Solution {

    /**
     * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
     * 每个元音'a'后面都只能跟着'e'
     * 每个元音'e'后面只能跟着'a'或者是'i'
     * 每个元音'i'后面不能 再跟着另一个'i'
     * 每个元音'o'后面只能跟着'i'或者是'u'
     * 每个元音'u'后面只能跟着'a'
     * <p>
     * a = [e]
     * e = [a,i]
     * i = [a,e,o,u]
     * o = [i,u]
     * u = [a]
     * <p>
     * a = 0,e = 1,i = 2,o = 3,u = 4
     * <p>
     * 0 =[1]
     * 1 =[0,2]
     * 2 =[0,1,3,4]
     * 3 =[2,4]
     * 4 =[0]
     */
    public int countVowelPermutation(int n) {
        long[][] nums = new long[n][5];
        Arrays.fill(nums[0], 1);
        int MOD = (int) 1e9 + 7;
        for (int i = 1; i < n; i++) {
            nums[i][0] = nums[i - 1][1];
            nums[i][1] = nums[i - 1][0] + nums[i - 1][2];
            nums[i][2] = nums[i - 1][0] + nums[i - 1][1] + nums[i - 1][3] + nums[i - 1][4];
            nums[i][3] = nums[i - 1][2] + nums[i - 1][4];
            nums[i][4] = nums[i - 1][0];
            for (int j = 0; j < 5; j++) {
                nums[i][j] %= MOD;
            }
        }
        long res = 0;
        for (int i = 0; i < 5; i++) {
            res += nums[n - 1][i];
        }
        return (int)(res % MOD);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countVowelPermutation(158));
        //System.out.println(solution.countVowelPermutation(1));
        //System.out.println(solution.countVowelPermutation(2));
        //System.out.println(solution.countVowelPermutation(3));
        //System.out.println(solution.countVowelPermutation(4));
        //System.out.println(solution.countVowelPermutation(5));
    }
}