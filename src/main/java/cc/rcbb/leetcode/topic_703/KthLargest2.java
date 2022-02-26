package cc.rcbb.leetcode.topic_703;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序
 */
class KthLargest2 {

    private int k;
    private List<Integer> list = new ArrayList<>();

    public KthLargest2(int k, int[] nums) {
        this.k = k;
        for (int i : nums) {
            list.add(i);
        }
    }

    public int add(int val) {
        list.add(val);
        // 快排，从小到大
        Collections.sort(list);
        return list.get(list.size() - k);
    }

    public static void main(String[] args) {
        //输入：
        //["KthLargest", "add", "add", "add", "add", "add"]
        //[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
        //输出：
        //[null, 4, 5, 5, 8, 8]
        KthLargest2 kthLargest21 = new KthLargest2(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest21.add(3));
        System.out.println(kthLargest21.add(5));
        System.out.println(kthLargest21.add(10));
        System.out.println(kthLargest21.add(9));
        System.out.println(kthLargest21.add(4));
    }
}