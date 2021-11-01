package cc.rcbb.leetcode.topic_83;


public class Solution {
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = head;
        ListNode tempNode = null;
        while (start != null) {

        }
        return head;
    }


    public static void main(String[] args) {
        // 1-2-1-2-3
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(4, one);
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