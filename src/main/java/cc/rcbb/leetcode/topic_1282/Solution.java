package cc.rcbb.leetcode.topic_1282;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.*;

/**
 * 1282. 用户分组
 * https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
 */
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            List<Integer> orDefault = map.getOrDefault(groupSize, new ArrayList<>());
            orDefault.add(i);
            map.put(groupSize, orDefault);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer size = entry.getKey();
            List<Integer> list = entry.getValue();
            if (list.size() < size) {
                res.add(list);
            } else {
                List<Integer> tempList = new ArrayList<>();
                int index = 0;
                for (Integer i : list) {
                    tempList.add(i);
                    index++;
                    if (index == size) {
                        index = 0;
                        res.add(tempList);
                        tempList = new ArrayList<>();
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：groupSizes = [3,3,3,3,3,1,3]
        // 输出：[[5],[0,1,2],[3,4,6]]
        RcbbPrinter.printIntegerList(solution.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
        // 输入：groupSizes = [2,1,3,3,3,2]
        // 输出：[[1],[0,5],[2,3,4]]
        RcbbPrinter.printIntegerList(solution.groupThePeople(new int[]{2,1,3,3,3,2}));

    }

}