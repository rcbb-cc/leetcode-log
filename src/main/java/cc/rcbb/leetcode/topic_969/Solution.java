package cc.rcbb.leetcode.topic_969;

import java.util.ArrayList;
import java.util.List;

/**
 * 969. 煎饼排序
 * https://leetcode-cn.com/problems/pancake-sorting/
 */
class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for (int i = n; i > 1; i--) {
            int index = 0;
            for (int j = 1; j < i; j++) {
                // 找出最大值下标
                if (arr[j] >= arr[index]) {
                    index = j;
                }
            }
            if (index == i - 1) {
                continue;
            }
            // 调转[0,index]的数据，使当前最大值放到第一位
            reverse(arr, index);
            // 调转[0,i-1]的数据，使得最大值放到了最后
            reverse(arr, i - 1);
            res.add(index + 1);
            res.add(i);
        }
        return res;
    }

    void reverse(int[] arr, int end) {
        for (int i = 0, j = end; i < j; i++, j--) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：[3,2,4,1]
        //输出：[4,2,4,3]
        //解释：
        //我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
        //初始状态 arr = [3, 2, 4, 1]
        //第一次翻转后（k = 4）：arr = [1, 4, 2, 3]
        //第二次翻转后（k = 2）：arr = [4, 1, 2, 3]
        //第三次翻转后（k = 4）：arr = [3, 2, 1, 4]
        //第四次翻转后（k = 3）：arr = [1, 2, 3, 4]，此时已完成排序
        System.out.println(solution.pancakeSort(new int[]{3, 2, 4, 1}));
    }
}