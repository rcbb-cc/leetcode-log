package cc.rcbb.leetcode.topic_978;

/**
 * 978. 最长湍流子数组
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/
 */
class Solution1 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int max = 1;
        int left = 0, right = 0;
        while (right < n - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
                right++;
            } else {
                if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}