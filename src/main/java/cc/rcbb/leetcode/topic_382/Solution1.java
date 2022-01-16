package cc.rcbb.leetcode.topic_382;

import cc.rcbb.leetcode.template.ListNode;

import java.util.Random;

/**
 * 382. 链表随机节点
 * https://leetcode-cn.com/problems/linked-list-random-node/
 */
class Solution1 {

    private ListNode head;
    private int size;
    private Random random;

    public Solution1(ListNode head) {
        this.head = head;
        ListNode t = head;
        while (t != null) {
            size++;
            t = t.next;
        }
        random = new Random();
    }

    public int getRandom() {
        int index = random.nextInt(size);
        int i = 0;
        ListNode t = head;
        while (i != index) {
            t = t.next;
            i++;
        }
        return t.val;
    }
}