package cc.rcbb.leetcode.topic_11;

/**
 * 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int max = 0;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    /**
     * 暴力，超时
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int n = height.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：[1,8,6,2,5,4,8,3,7]
        //输出：49
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        //输入：height = [1,1]
        //输出：1
        System.out.println(solution.maxArea(new int[]{1, 1}));
    }
}