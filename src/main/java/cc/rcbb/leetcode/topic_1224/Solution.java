package cc.rcbb.leetcode.topic_1224;

import java.util.HashMap;
import java.util.Map;

/**
 * 1224. 最大相等频率
 * https://leetcode.cn/problems/maximum-equal-frequency/
 */
class Solution {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count.getOrDefault(nums[i], 0) > 0) {
                freq.put(count.get(nums[i]), freq.get(count.get(nums[i])) - 1);
            }
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(nums[i]));
            freq.put(count.get(nums[i]), freq.getOrDefault(count.get(nums[i]), 0) + 1);
            // 1.最大出现次数为1
            boolean ok = maxFreq == 1 ||
                    // 2.所有数出现次数都是 maxFreq 或 maxFreq-1，并且最大出现次数的数只有一个
                    freq.get(maxFreq) * maxFreq + freq.get(maxFreq - 1) * (maxFreq - 1) == i + 1 && freq.get(maxFreq) == 1 ||
                    // 3.除开一个数，其他所有数的出现次数都是 maxFreq，并且该数的出现次数为 1
                    freq.get(maxFreq) * maxFreq + 1 == i + 1 && freq.get(1) == 1;
            if (ok) {
                res = Math.max(res, i + 1);
            }
        }
        return res;
    }
}