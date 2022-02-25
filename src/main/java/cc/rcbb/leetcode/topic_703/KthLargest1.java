package cc.rcbb.leetcode.topic_703;


import java.util.ArrayList;
import java.util.List;

/**
 * 冒泡，会超时
 */
class KthLargest1 {

    private int k;
    private List<Integer> list = new ArrayList<>();

    public KthLargest1(int k, int[] nums) {
        this.k = k;
        for (int i : nums) {
            list.add(i);
        }
    }

    public int add(int val) {
        list.add(val);
        int cur = 0;
        for (int i = 0; i < k; i++) {
            int index = findMax(cur, list.size() - 1);
            swap(cur++, index);
        }
        return list.get(cur - 1);
    }

    private int findMax(int start, int end) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            int t = list.get(i);
            if (t > max) {
                max = t;
                ans = i;
            }
        }
        return ans;
    }

    private void swap(int a, int b) {
        int t = list.get(a);
        list.set(a, list.get(b));
        list.set(b, t);
    }

    public static void main(String[] args) {
        //输入：
        //["KthLargest", "add", "add", "add", "add", "add"]
        //[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
        //输出：
        //[null, 4, 5, 5, 8, 8]
        KthLargest1 kthLargest1 = new KthLargest1(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest1.add(3));
        System.out.println(kthLargest1.add(5));
        System.out.println(kthLargest1.add(10));
        System.out.println(kthLargest1.add(9));
        System.out.println(kthLargest1.add(4));
    }
}