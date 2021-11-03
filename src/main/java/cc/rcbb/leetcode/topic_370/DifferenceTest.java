package cc.rcbb.leetcode.topic_370;

import cc.rcbb.leetcode.common.RcbbPrinter;

public class DifferenceTest {

    public static void main(String[] args) {
        int n = 5 + 1;
        int[] arr = new int[n];
        Difference difference = new Difference(arr);
        difference.increment(1,2,10);
        difference.increment(2,3,20);
        difference.increment(2,5,25);
        int[] result = difference.result();
        RcbbPrinter.print(result);
    }

}
