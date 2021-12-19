package cc.rcbb.leetcode.topic_997;


/**
 * 997. 找到小镇的法官
 * https://leetcode-cn.com/problems/find-the-town-judge/
 * <p>
 * 思路：法官不信任所有人、所有人都信任法官
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }
        int[] arr = new int[n + 1];
        for (int[] a : trust) {
            arr[a[0]]--;
            arr[a[1]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public int findJudge2(int n, int[][] trust) {
        int[][] people = new int[n][2];

        for (int[] a : trust) {
            people[a[0] - 1][0]++;
            people[a[1] - 1][1]++;
        }
        for (int i = 0; i < n; i++) {
            if (people[i][0] == 0 && people[i][1] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public int findJudge1(int n, int[][] trust) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][i] = 1;
        }
        for (int[] a : trust) {
            arr[a[0] - 1][a[1] - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (arr[j][i] != 1) {
                    flag = false;
                    continue;
                }
            }
            if (flag) {
                boolean colFlag = true;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        if (arr[i][j] == 1) {
                            colFlag = false;
                            continue;
                        }
                    }
                }
                if (colFlag) {
                    return i + 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findJudge(2, new int[][]{{1, 2}}));
        System.out.println(solution.findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(solution.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        System.out.println(solution.findJudge(3, new int[][]{{1, 3}, {3, 1}}));
        System.out.println(solution.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));

    }
}