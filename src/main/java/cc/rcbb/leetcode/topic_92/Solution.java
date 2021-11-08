package cc.rcbb.leetcode.topic_92;

/**
 * 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class Solution {

    public static void main(String[] args) {
        // 1-2-1-2-3
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(4, one);
        ListNode one1 = new ListNode(3, two);
        ListNode two2 = new ListNode(2, one1);
        ListNode three = new ListNode(1, two2);

        print(three);
        int left = 1;
        int right = 3;

        Solution solution = new Solution();
        ListNode listNode = solution.reverse(three);
        //ListNode listNode = solution.reverseN(three, 2);
        //ListNode listNode = solution.reverseBetween(three, 2, 4);
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


    public ListNode reverse(ListNode head) {
        System.out.println("head1 = " + head);
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        System.out.println("last = " + last);
        System.out.println("head2 = " + head);
        head.next.next = head;
        head.next = null;
        System.out.println("head3 = " + head);
        return last;
    }

    public ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            System.out.println("successor = " + successor);
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }


    public ListNode leftNode = null;
    public ListNode rightNode = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head.next, right);
        }
        head.next = reverseBetween(head, left - 1, right - 1);
        return head;
    }
}