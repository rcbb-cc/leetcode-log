package cc.rcbb.leetcode.topic_825;

import java.util.Arrays;

/**
 * 825. 适龄的朋友
 * https://leetcode-cn.com/problems/friends-of-appropriate-ages/
 */
class Solution {

    /**
     * 根据题目我们知道加好友的条件需要满足如下布尔表达式：
     * ! ( (ages[y] <= 0.5 * ages[x] + 7) || (ages[y] > ages[x]) || (ages[y] > 100 && ages[x] < 100) )
     * 化简可得：
     * ages[y] > 0.5 * ages[x] + 7 &&
     * ages[y] <= ages[x] &&
     * (ages[y] <= 100 || ages[x] >= 100)
     * # 也就是x和y满足以下两者之一，x就可以向y发送好友请求：
     * # 1. ages[y] <= ages[x] < (ages[y] - 7) * 2 && ages[y] <= 100
     * # 2. 0.5 * ages[x] + 7 < ages[y] <= ages[x] && ages[x] >= 100
     * <p>
     * 根据这个布尔表达式我们知道，x可以添加好友的y是一个范围，可以使用前缀和快速统计一个范围内的人数，从而求解答案。
     */
    public int numFriendRequests(int[] ages) {
        int res = 0;
        Arrays.sort(ages);
        int n = ages.length;
        int left = 0;
        int right = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                left++;
            }
            while (right + 1 < n &&
                    ages[right + 1] <= age) {
                right++;
            }
            res += right - left;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：ages = [16,16]
        //输出：2
        //解释：2 人互发好友请求。
        System.out.println(solution.numFriendRequests(new int[]{16, 16}));
        //输入：ages = [16,17,18]
        //输出：2
        //解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
        System.out.println(solution.numFriendRequests(new int[]{16, 17, 18}));
        //输入：ages = [20,30,100,110,120]
        //输出：3
        //解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
        System.out.println(solution.numFriendRequests(new int[]{20, 30, 100, 110, 120}));
    }
}