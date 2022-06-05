package cc.rcbb.leetcode.topic_478;

import java.util.Random;

/**
 * 478. 在圆内随机生成点
 * https://leetcode.cn/problems/generate-random-point-in-a-circle/
 */
class Solution {

    double r, x, y;
    Random random = new Random();

    public Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
        double len = Math.sqrt(random.nextDouble() * r * r);
        double ang = random.nextDouble() * 2 * Math.PI;
        double nx = x + len * Math.cos(ang);
        double ny = y + len * Math.sin(ang);
        return new double[]{nx, ny};
    }
}