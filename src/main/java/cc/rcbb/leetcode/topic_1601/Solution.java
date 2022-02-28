package cc.rcbb.leetcode.topic_1601;

/**
 * 1601. 最多可达成的换楼请求数目
 * https://leetcode-cn.com/problems/maximum-number-of-achievable-transfer-requests/
 */
class Solution {
    public int maximumRequests(int n, int[][] requests) {
        return dfs(new int[n], requests, 0, 0);
    }

    private int dfs(int[] count, int[][] requests, int cur, int chosen) {
        if (cur >= requests.length) {
            if (isAcceptable(count)) {
                return chosen;
            }
            return 0;
        }
        int ret = dfs(count, requests, cur + 1, chosen);

        count[requests[cur][0]] -= 1;
        count[requests[cur][1]] += 1;
        ret = Math.max(ret, dfs(count, requests, cur + 1, chosen + 1));
        count[requests[cur][0]] += 1;
        count[requests[cur][1]] -= 1;
        return ret;
    }

    private boolean isAcceptable(int[] count) {
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：n = 5, requests = [[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]
        //输出：5
        System.out.println(solution.maximumRequests(5, new int[][]{{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}}));
        //输入：n = 3, requests = [[0,0],[1,2],[2,1]]
        //输出：3
        System.out.println(solution.maximumRequests(3, new int[][]{{0, 0}, {1, 2}, {2, 1}}));
        //输入：n = 4, requests = [[0,3],[3,1],[1,2],[2,0]]
        //输出：4
        System.out.println(solution.maximumRequests(4, new int[][]{{0, 3}, {3, 1}, {1, 2}, {2, 0}}));
        //3
        //[[1,2],[1,2],[2,2],[0,2],[2,1],[1,1],[1,2]]
        System.out.println(solution.maximumRequests(3, new int[][]{{1, 2}, {1, 2}, {2, 2}, {0, 2}, {2, 1}, {1, 1}, {1, 2}}));
        //3
        //[[0,0],[1,1],[0,0],[2,0],[2,2],[1,1],[2,1],[0,1],[0,1]]
        System.out.println(solution.maximumRequests(3, new int[][]{{0, 0}, {1, 1}, {0, 0}, {2, 0}, {2, 2}, {1, 1}, {2, 1}, {0, 1}, {0, 1}}));
    }

}