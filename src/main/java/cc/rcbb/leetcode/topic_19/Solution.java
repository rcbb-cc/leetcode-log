package cc.rcbb.leetcode.topic_19;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        if (p == null) {
            return head.next;
        }
        ListNode q = head;
        while (p!= null && p.next != null) {
            p = p.next;
            q = q.next;
        }
        ListNode s = q.next;
        q.next = s.next;
        s = null;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);

        ListNode list = solution.removeNthFromEnd(listNode, 2);
        System.out.println(list);

    }
}