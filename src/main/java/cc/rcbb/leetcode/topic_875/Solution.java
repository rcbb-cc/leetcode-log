package cc.rcbb.leetcode.topic_875;

import cc.rcbb.leetcode.common.RcbbPrinter;

import java.util.Arrays;

public class Solution {
    public int minEatingSpeed0(int[] piles, int h) {
        Arrays.sort(piles);
        int length = piles.length;
        if (length == h) {
            return piles[length - 1];
        } else {
            int min = piles[0];
            int sum = 1;
            while (sum != h) {
                sum = 1;
                for (int i = 1; i < length; i++) {
                    int s = piles[i] / min;
                    if (piles[i] % min != 0) {
                        s++;
                    }
                    if (s == 0) {
                        sum++;
                    } else {
                        sum += s;
                    }
                }
                if (sum == h) {
                    break;
                }
                min++;
            }
            return min;
        }
    }

    public int minEatingSpeed1(int[] piles, int h) {
        Arrays.sort(piles);
        RcbbPrinter.print(piles);
        int length = piles.length;
        if (length == h) {
            return piles[length - 1];
        } else {
            int min = piles[0];
            int sum = 1;
            while (sum != h) {
                System.out.println("start==========");
                System.out.println("min=" + min);
                sum = 1;
                for (int i = 1; i < length; i++) {
                    System.out.println("pile[" + i + "]=" + piles[i]);

                    int s = piles[i] / min;
                    if (piles[i] % min != 0) {
                        s++;
                    }
                    if (s == 0) {
                        sum++;
                    } else {
                        sum += s;
                    }
                    System.out.println("s=" + s + ",sum=" + sum);
                }
                System.out.println("==========end");
                if (sum == h) {
                    break;
                }
                min++;
            }
            return min;
        }
    }

    // 主函数，在 f(x) == target 的约束下求 x 的最值
    public int minEatingSpeed3(int[] piles, int h) {
        Arrays.sort(piles);
        RcbbPrinter.print(piles);
        int length = piles.length;
        if (length == h) {
            return piles[length - 1];
        }

        // 问自己：自变量 x 的最小值是多少？
        int left = piles[0];
        // 问自己：自变量 x 的最大值是多少？
        int right = piles[length - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = f(piles, mid);
            if (sum == h) {
                // 问自己：题目是求左边界还是右边界？
                right = mid - 1;
            } else if (sum < h) {
                // 问自己：怎么让 f(x) 大一点？
                right = mid - 1;
            } else if (sum > h) {
                // 问自己：怎么让 f(x) 小一点？
                left = mid + 1;
            }
        }
        if (f(piles, left) == h) {
            return left;
        }
        return left + 1;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = f(piles, mid);
            if (sum == h) {
                right = mid;
            } else if (sum < h) {
                right = mid;
            } else if (sum > h) {
                left = mid + 1;
            }
        }
        return left;
    }

    public int f(int piles[], int mid) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i] / mid;
            if (piles[i] % mid != 0) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入: piles = [3,6,7,11], H = 8 输出: 4
        //int[] piles = new int[]{3, 6, 7, 11};
        //int h = 8;

        // 输入: piles = [30,11,23,4,20], H = 5 输出: 30
        //int[] piles = new int[]{30,11,23,4,20};
        //int h = 5;

        // 输入: piles = [30,11,23,4,20], H = 6 输出: 23
        int[] piles = new int[]{30, 11, 23, 4, 20};
        int h = 6;
        int s = solution.minEatingSpeed(piles, h);
        System.out.println(s);
    }
}