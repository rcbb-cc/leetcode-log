package cc.rcbb.leetcode.topic_398;

import java.util.*;

/**
 * 398. 随机数索引
 * https://leetcode-cn.com/problems/random-pick-index/
 */
class Solution1 {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Random random;

    public Solution1(int[] nums) {
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            list.add(i);
            map.put(num, list);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
