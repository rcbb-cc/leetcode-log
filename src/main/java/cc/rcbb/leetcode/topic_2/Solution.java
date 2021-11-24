package cc.rcbb.leetcode.topic_2;

import cc.rcbb.leetcode.common.RcbbPrinter;
import cc.rcbb.leetcode.template.ListNode;

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode curr = root;
        int sum = 0;
        while (l1 != null || l2 != null || sum != 0) {
            int s1 = 0;
            if (l1 != null) {
                s1 = l1.val;
                l1 = l1.next;
            }
            int s2 = 0;
            if (l2 != null) {
                s2 = l2.val;
                l2 = l2.next;
            }
            sum = sum + s1 + s2;
            ListNode node = new ListNode(sum % 10);
            sum = sum / 10;
            curr.next = node;
            curr = node;
        }
        return root.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode three = new ListNode(3, null);
        ListNode four = new ListNode(4, three);
        ListNode two = new ListNode(2, four);


        ListNode four1 = new ListNode(4, null);
        ListNode six = new ListNode(6, four1);
        ListNode five = new ListNode(5, six);

        ListNode result = solution.addTwoNumbers(two, five);
        RcbbPrinter.print(result);

    }

}