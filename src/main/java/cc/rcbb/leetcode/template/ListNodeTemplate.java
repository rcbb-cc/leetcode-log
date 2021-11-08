package cc.rcbb.leetcode.template;


/**
 * <p>
 * ListNodeTemplate
 * </p>
 *
 * @author lvhao
 * @date 2021/11/8
 */
public class ListNodeTemplate {

    /**
     * 返回链表的倒数第 k 个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode findFromEnd(ListNode head, int k) {
        // 假设长度一共为n
        ListNode start = head;
        // start先走了k步
        for (int i = 0; i < k; i++) {
            start = start.next;
        }

        ListNode p = head;
        // p和start一起走了n-k步
        while (start != null) {
            start = start.next;
            p = p.next;
        }
        // 所以现在p在n-k
        return p;
    }

    /**
     * 单链表的中点
     * 我们让两个指针 slow 和 fast 分别指向链表头结点 head。
     * 每当慢指针 slow 前进一步，快指针 fast 就前进两步，这样，当 fast 走到链表末尾时，slow 就指向了链表中点。
     *
     * @param head
     * @return
     */
    public ListNode middle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 判断链表是否包含环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
}
