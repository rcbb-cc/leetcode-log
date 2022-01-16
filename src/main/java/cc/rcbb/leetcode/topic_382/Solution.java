package cc.rcbb.leetcode.topic_382;

import cc.rcbb.leetcode.template.ListNode;

import java.util.Random;

/**
 * 382. 链表随机节点
 * https://leetcode-cn.com/problems/linked-list-random-node/
 */
class Solution {

    private ListNode head;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int index = 0;
        int res = 0;
        ListNode t = head;
        while (t != null) {
            index++;
            if (random.nextInt(index) == 0) {
                res = t.val;
            }
            t = t.next;
        }
        return res;
    }
}
