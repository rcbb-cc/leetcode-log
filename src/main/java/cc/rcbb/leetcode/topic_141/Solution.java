package cc.rcbb.leetcode.topic_141;

import cc.rcbb.leetcode.template.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null || slow == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：head = [3,2,0,-4], pos = 1 输出：true
        ListNode listNode = new ListNode(1);
        listNode.next = null;
        boolean r = solution.hasCycle(listNode);
        System.out.println(r);
    }
}