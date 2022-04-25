package cc.rcbb.leetcode.topic_398;

import java.util.Random;

/**
 * 398. 随机数索引
 * https://leetcode-cn.com/problems/random-pick-index/
 */
class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int pick(int target) {
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                cnt++;
                if (random.nextInt(cnt) == 0) {
                    ans = i;
                }
            }
        }
        return ans;
    }
}