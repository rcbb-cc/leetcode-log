package cc.rcbb.leetcode.topic_658;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * https://leetcode.cn/problems/find-k-closest-elements/
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        });
        List<Integer> result = list.subList(0, k);
        Collections.sort(result);
        return result;
    }
}