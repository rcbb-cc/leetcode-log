package cc.rcbb.leetcode.topic_599;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.*;

/**
 * 599. 两个列表的最小索引总和
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 */
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (!map.containsKey(list2[i])) {
                continue;
            }
            int sum = map.get(list2[i]) + i;
            if (sum < min) {
                res.clear();
                min = sum;
                res.add(list2[i]);
            } else if (sum == min) {
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
        //输出: ["Shogun"]
        //解释: 他们唯一共同喜爱的餐厅是“Shogun”。
        RcbbPrinter.print(solution.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}));
        //输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
        //输出: ["Shogun"]
        //解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
        RcbbPrinter.print(solution.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"}));
    }
}