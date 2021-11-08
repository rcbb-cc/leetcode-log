package cc.rcbb.leetcode.topic_160;

import java.util.List;

public class Solution {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        ListNode result = null;
        ListNode startA = headA;
        while (startA != null) {

            ListNode startB = headB;
            while (startB != null) {
                if (startA == startB) {
                    result = startA;
                    break;
                }
                startB = startB.next;
            }
            if (result != null) {
                break;
            }
            startA = startA.next;
        }
        return result;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            if (p == null) {
                p = headB;
            } else {
                p = p.next;
            }
            if (q == null){
                q = headA;
            } else {
                q = q.next;
            }
        }
        return q;
    }


    public static void main(String[] args) {

    }

}