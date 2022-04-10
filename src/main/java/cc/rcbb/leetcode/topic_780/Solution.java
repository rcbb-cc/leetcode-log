package cc.rcbb.leetcode.topic_780;

/**
 * 780. 到达终点
 * https://leetcode-cn.com/problems/reaching-points/
 */
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        if (tx == sx && ty == sy) {
            return true;
        } else if (tx == sx) {
            return ty > sy && (ty - sy) % tx == 0;
        } else if (ty == sy) {
            return tx > sx && (tx - sx) % ty == 0;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入: sx = 1, sy = 1, tx = 3, ty = 5
        //输出: true
        //解释:
        //可以通过以下一系列转换从起点转换到终点：
        //(1, 1) -> (1, 2)
        //(1, 2) -> (3, 2)
        //(3, 2) -> (3, 5)
        System.out.println(solution.reachingPoints(1, 1, 3, 5));
        //输入: sx = 1, sy = 1, tx = 2, ty = 2
        //输出: false
        System.out.println(solution.reachingPoints(1, 1, 2, 2));
        //输入: sx = 1, sy = 1, tx = 1, ty = 1
        //输出: true
        System.out.println(solution.reachingPoints(1, 1, 1, 1));
    }
}