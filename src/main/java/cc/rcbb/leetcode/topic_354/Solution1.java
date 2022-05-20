package cc.rcbb.leetcode.topic_354;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 354. 俄罗斯套娃信封问题
 * https://leetcode.cn/problems/russian-doll-envelopes/
 */
class Solution1 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) {
            return n;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });
        List<Integer> f = new ArrayList<>();
        f.add(envelopes[0][1]);
        for (int i = 0; i < n; i++) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int left = 0, right = f.size() - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (f.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        // 输入：envelopes = [[5, 4],[6, 4],[6, 7],[2, 3]]
        // 输出：3
        // 解释：最多信封的个数为 3, 组合为: [2, 3] => [5, 4] => [6, 7]。
        System.out.println(solution.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        // 输入：envelopes = [[1, 1],[1, 1],[1, 1]]
        // 输出：1
        System.out.println(solution.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}}));

    }
}