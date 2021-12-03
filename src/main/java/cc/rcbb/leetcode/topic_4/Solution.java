package cc.rcbb.leetcode.topic_4;


import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/submissions/
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = 0;
        int len2 = 0;
        int n = 0;
        int[] arr = new int[nums1.length + nums2.length];
        while (len1 < nums1.length || len2 < nums2.length) {
            if (len1 < nums1.length && len2 < nums2.length) {
                if (nums1[len1] < nums2[len2]) {
                    arr[n++] = nums1[len1++];
                } else {
                    arr[n++] = nums2[len2++];
                }
            }
            if (len1 < nums1.length && len2 >= nums2.length) {
                arr[n++] = nums1[len1++];
            }
            if (len1 >= nums1.length && len2 < nums2.length) {
                arr[n++] = nums2[len2++];
            }
        }
        if (n % 2 != 0) {
            return 1.0 * arr[n / 2];
        }
        return 1.0 * (arr[n / 2] + arr[n / 2 - 1]) / 2;
    }

    /**
     * 使用System.arraycopy进行copy，再使用Arrays.sort进行排序
     * 如果是n个数，n为奇数则为第[n/2]个数，n为偶数则为[n/2]+[n/2-1]和的一半
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int n = len1 + len2;
        int[] arr = new int[n];
        System.arraycopy(nums1, 0, arr, 0, len1);
        System.arraycopy(nums2, 0, arr, len1, len2);
        Arrays.sort(arr);
        if (arr.length % 2 != 0) {
            return 1.0 * arr[n / 2];
        }
        return 1.0 * (arr[n / 2] + arr[n / 2 - 1]) / 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] num1 = new int[]{1, 3};
        //int[] num2 = new int[]{2};
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{3, 4};
        double r = solution.findMedianSortedArrays(num1, num2);
        System.out.println(r);
    }
}