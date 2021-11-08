package cc.rcbb.leetcode.topic_142;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇
            if (slow == fast) {
                /**
                 * a：链表头部到链表入口有a个节点；
                 * b：链表环有b个节点；
                 *
                 * 当快慢指针相遇时，s和f走过的节点为：
                 * f=s+nb，f一直在环里面转；
                 * 并且 f=2s；经过的总节点数f是s的两倍；
                 * 可以得出 s=nb；
                 *
                 *  1.走到链表入口节点时的步数 是：k=a+nb；
                 *  2.fast和slow第一次相遇，slow已经走过nb步，需要再走a步到达入口；
                 *  3.head指针走a步到达入口（head赋值给fast），fast和slow一起走，每次走一步，再次相遇时，到达入口（走了a步）
                 */
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                // 返回环的入口
                return slow;
            }
        }
        return null;
    }

}