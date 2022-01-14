package cc.rcbb.leetcode.topic_373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的K对数字
 * https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2) -> {
            return nums1[o1[0]] + nums2[o1[1]] - (nums1[o2[0]] + nums2[o2[1]]);
        });
        int n1 = nums1.length;
        int n2 = nums2.length;

        for (int i = 0; i < Math.min(n1, k); i++) {
            pq.offer(new int[]{i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] indexArray = pq.poll();
            List<Integer> t = new ArrayList<>();
            t.add(nums1[indexArray[0]]);
            t.add(nums2[indexArray[1]]);
            result.add(t);
            if (indexArray[1] + 1 < n2) {
                pq.offer(new int[]{indexArray[0], indexArray[1] + 1});
            }
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //   输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
        //   输出: [1,2],[1,4],[1,6]
        //   解释: 返回序列中的前 3 对数：
        // [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
        System.out.println(solution.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));

        //输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
        //输出: [1,1],[1,1]
        //解释: 返回序列中的前 2 对数：
        // [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
        System.out.println(solution.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));

    }
}