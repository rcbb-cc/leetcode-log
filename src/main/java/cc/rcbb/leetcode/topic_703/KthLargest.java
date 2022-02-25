package cc.rcbb.leetcode.topic_703;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */
class KthLargest {

    private int k;
    private PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        int n = nums.length;
        for (int i = 0; i < k && i < n; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < n; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        int t = !queue.isEmpty() ? queue.peek() : Integer.MIN_VALUE;
        if (val > t || queue.size() < k) {
            if (!queue.isEmpty() && queue.size() >= k) {
                queue.poll();
            }
            queue.add(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        //输入：
        //["KthLargest", "add", "add", "add", "add", "add"]
        //[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
        //输出：
        //[null, 4, 5, 5, 8, 8]
        KthLargest kthLargest21 = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest21.add(3));
        System.out.println(kthLargest21.add(5));
        System.out.println(kthLargest21.add(10));
        System.out.println(kthLargest21.add(9));
        System.out.println(kthLargest21.add(4));
    }
}