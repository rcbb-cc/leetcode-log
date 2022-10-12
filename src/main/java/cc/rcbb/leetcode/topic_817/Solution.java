package cc.rcbb.leetcode.topic_817;

import cc.rcbb.leetcode.template.ListNode;

import java.util.*;

/**
 * 817. 链表组件
 * https://leetcode.cn/problems/linked-list-components/
 */
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        boolean inSet = false;
        int res = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    res++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode zone = new ListNode(0);
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = zone;
        zone.next = four;
        four.next = three;
        three.next = null;
        System.out.println(solution.numComponents(one, new int[]{3, 4, 0, 2, 1}));
    }
}