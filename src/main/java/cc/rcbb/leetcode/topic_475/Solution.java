package cc.rcbb.leetcode.topic_475;

import java.util.Arrays;

/**
 * 475. 供暖器
 * https://leetcode-cn.com/problems/heaters/
 */
class Solution {

    public int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0;
        int radius = 0;
        for (int house : houses) {
            // 找出房子右边的一个供暖器
            while (i < heaters.length && heaters[i] < house) {
                i++;
            }
            if (i == 0) {
                // 是第一个供暖器
                radius = Math.max(radius, heaters[i] - house);
            } else if (i == heaters.length) {
                // 是最后一个供暖器
                return Math.max(radius, houses[houses.length - 1] - heaters[heaters.length - 1]);
            } else {
                // 房屋右侧和左侧的供暖器，取小的那个
                // 但结果取距离最大的
                radius = Math.max(radius, Math.min(heaters[i] - house, house - heaters[i - 1]));
            }

        }
        return radius;
    }

    /**
     * 对于每个房屋：
     * 1.要么用前面的
     * 2.要么用后面的
     * 两者取最近的。
     * <p>
     * 对于所有的房屋，选择上面取得的最大的。
     * <p>
     * 问题来了：
     * 如何求每个房屋，左右边供暖器的位置？
     * 1.对heaters进行排序；
     * 2.遍历每个房屋，二分数组heaters找到大于house的第一个供暖器的位置；
     * 3.也就是house右边的第一个供暖器，右边找到了，house左边的也就找到了；
     * <p>
     * 需要注意：一定要在边界内；
     */
    public int findRadius2(int[] houses, int[] heaters) {
        int distance = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int i = binarySearch(heaters, house);
            if (i == 0) {
                distance = Math.max(distance, heaters[i] - house);
            } else if (i == heaters.length) {
                distance = Math.max(distance, house - heaters[i - 1]);
            } else {
                distance = Math.max(distance, Math.min(house - heaters[i - 1], heaters[i] - house));
            }
        }
        return distance;
    }

    public int binarySearch(int[] heaters, int house) {
        int left = 0;
        int right = heaters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] == house) {
                right = mid - 1;
            } else if (heaters[mid] > house) {
                right = mid - 1;
            } else if (heaters[mid] < house) {
                left = mid + 1;
            }
        }
        return left;
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            int curDistance = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1 &&
                    Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(solution.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println(solution.findRadius(new int[]{1, 5}, new int[]{2}));
        System.out.println(solution.findRadius(new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923}, new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612}));
    }
}