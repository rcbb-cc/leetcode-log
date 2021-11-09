package cc.rcbb.leetcode.topic_83;

import cc.rcbb.leetcode.template.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class Solution {

    /**
     * 快慢指针
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // 数值不同时，慢指针向前走一步
                slow = slow.next;
            } else {
                // 数值相同时，慢指针向前走两步
                slow.next = fast.next;
            }
            fast = fast.next;
        }
        return head;
    }

    /**
     * 简化
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val != cur.next.val) {
                // 当前值与下个值不同时，走一步
                cur = cur.next;
            } else {
                // 当前值与下个值相同时，走两步
                cur.next = cur.next.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        // 1-2-1-2-3
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(2, one);
        ListNode one1 = new ListNode(2, two);
        ListNode two2 = new ListNode(2, one1);
        ListNode three = new ListNode(1, two2);

        print(three);

        Solution solution = new Solution();
        ListNode listNode = solution.deleteDuplicates(three);
        print(listNode);

    }

    public static void print(ListNode head) {
        ListNode start = head;
        while (start.next != null) {
            System.out.print(start.val + "->");
            start = start.next;
        }
        System.out.print(start.val);
        System.out.println("");
    }

}