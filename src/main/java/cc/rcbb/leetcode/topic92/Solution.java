package cc.rcbb.leetcode.topic92;

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
//        ListNode listNode = solution.reverse(three);
        ListNode listNode = solution.reverseN(three, 3);
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
        System.out.println("head = " + head);
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        System.out.println("last = " + last);
        System.out.println("head2 = " + last);
        head.next.next = head;
        head.next = null;
        System.out.println("head3 = " + last);
        return last;
    }

    public ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = head;
        int k = 1;
        int temp;
        ListNode tempNode = new ListNode();
        while (start != null) {
            if (k == left) {
                tempNode = start;
            }
            if (k == right) {
            }
        }
        return head;
    }
}