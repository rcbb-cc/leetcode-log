package cc.rcbb.leetcode.topic_954;

import java.util.*;

/**
 * 954. 二倍数对数组
 * https://leetcode-cn.com/problems/array-of-doubled-pairs/
 */
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);

        }
        if (map.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        for (Integer key: map.keySet()) {
            list.add(key);
        }
        Collections.sort(list, (a, b) -> Math.abs(a) - Math.abs(b));
        for (Integer i : list) {
            if (map.getOrDefault(2 * i, 0) < map.get(i)) {
                return false;
            }
            map.put(2 * i, map.getOrDefault(2 * i, 0) - map.get(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：arr = [3,1,3,6]
        //输出：false
        System.out.println(solution.canReorderDoubled(new int[]{3, 1, 3, 6}));
        //输入：arr = [2,1,2,6]
        //输出：false
        System.out.println(solution.canReorderDoubled(new int[]{2, 1, 2, 6}));
        //输入：arr = [4,-2,2,-4]
        //输出：true
        //解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
        System.out.println(solution.canReorderDoubled(new int[]{4, -2, 2, -4}));
        //输入：[1,2,1,-8,8,-4,4,-4,2,-2]
        //true
        System.out.println(solution.canReorderDoubled(new int[]{1, 2, 1, -8, 8, -4, 4, -4, 2, -2}));
    }
}