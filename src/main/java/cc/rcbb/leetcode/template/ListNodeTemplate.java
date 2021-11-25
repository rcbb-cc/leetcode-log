package cc.rcbb.leetcode.template;


import cc.rcbb.leetcode.common.RcbbPrinter;

/**
 * <p>
 * ListNodeTemplate
 * </p>
 *
 * @author lvhao
 * @date 2021/11/8
 */
public class ListNodeTemplate {

    public static void main(String[] args) {
        ListNodeTemplate template = new ListNodeTemplate();
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        ListNode node = template.reverse(one);
        RcbbPrinter.print(node);

    }

    /**
     * 迭代，反转
     */
    public ListNode iterate(ListNode head) {
        // 用来存储前一个节点，最开始为null
        ListNode prev = null;
        // 用来存储下一个节点
        ListNode next;
        // 当前节点
        ListNode curr = head;
        while (curr != null) {
            // 记录下一个节点
            next = curr.next;
            // 当前节点指向前一个节点
            curr.next = prev;
            // 将当前节点赋值给前一个节点
            prev = curr;
            // 将下一个节点赋值给当前节点
            curr = next;
        }
        // 返回前一个节点，即之前的最后一个节点
        return prev;
    }

    /**
     * 递归，反转
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 最后一个，为新开头
        ListNode newHead = reverse(head.next);
        // 使倒数第二个指向倒数第一个的next 指向 倒数第二个
        // 4 -> 5 -> 4
        head.next.next = head;
        // 使倒数第二个指向NULL，砍断
        // 4 -x-> 5 -> 4
        head.next = null;
        // 返回新头部
        return newHead;
    }

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
            if (q == null) {
                q = headA;
            } else {
                q = q.next;
            }
        }
        return q;
    }
}
