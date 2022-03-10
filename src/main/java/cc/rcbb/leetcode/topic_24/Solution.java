package cc.rcbb.leetcode.topic_24;

import cc.rcbb.leetcode.common.RcbbPrinter;
import cc.rcbb.leetcode.template.ListNode;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode root = new ListNode();
        root.next = head;
        ListNode curr = root;
        while (curr.next != null && curr.next.next != null) {
            ListNode node1 = curr.next;
            ListNode node2 = curr.next.next;
            curr.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            curr = node1;
        }
        return root.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        RcbbPrinter.print(solution.swapPairs(node1));
    }
}