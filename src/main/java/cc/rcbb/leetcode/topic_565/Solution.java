package cc.rcbb.leetcode.topic_565;

/**
 * 565. 数组嵌套
 * https://leetcode.cn/problems/array-nesting/
 */
class Solution {
    public int arrayNesting(int[] nums) {
        int ans = 0;
        int n = nums.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            while (!vis[i]) {
                vis[i] = true;
                i = nums[i];
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }
}