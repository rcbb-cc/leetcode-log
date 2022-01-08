package cc.rcbb.leetcode.topic_89;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. 格雷编码
 * https://leetcode-cn.com/problems/gray-code/
 */
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        for (int i = 1; i < n; i++) {
            int t = res.size();
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + t);
            }
        }
        return res;
    }

    public List<Integer> grayCode1(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int head = 1 << i;
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) | head);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.grayCode(1));
        System.out.println(solution.grayCode(2));
        System.out.println(solution.grayCode(3));
        System.out.println(solution.grayCode(4));
    }
}