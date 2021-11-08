package cc.rcbb.leetcode.topic_876;

/**
 * 876. 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        int length = getLength(head);
        int middle = length / 2;
        int count = 0;
        while (head != null) {
            if (count == middle) {
                break;
            }
            head = head.next;
            count++;
        }
        return head;
    }

    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：[1,2,3,4,5] 输出：此列表中的结点 3 (序列化形式：[3,4,5])

    }
}