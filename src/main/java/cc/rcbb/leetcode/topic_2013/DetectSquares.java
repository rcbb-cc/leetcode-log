package cc.rcbb.leetcode.topic_2013;

import java.util.HashMap;
import java.util.Map;

/**
 * 2013. 检测正方形
 * https://leetcode-cn.com/problems/detect-squares/
 */
class DetectSquares {

    private Map<Integer, Map<Integer, Integer>> xMap;
    private Map<Integer, Map<Integer, Integer>> yMap;

    public DetectSquares() {
        xMap = new HashMap<>();
        yMap = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        Map<Integer, Integer> xm = xMap.getOrDefault(x, new HashMap<>());
        xm.put(y, xm.getOrDefault(y, 0) + 1);
        xMap.put(x, xm);

        Map<Integer, Integer> ym = yMap.getOrDefault(y, new HashMap<>());
        ym.put(x, ym.getOrDefault(x, 0) + 1);
        yMap.put(y, ym);
    }

    public int count(int[] point) {
        // a点坐标
        int x = point[0];
        int y = point[1];
        int result = 0;
        // 寻找b点坐标，y相同
        if (!yMap.containsKey(y)) {
            return 0;
        }
        Map<Integer, Integer> sameX = yMap.get(y);
        // 多个y相同的点
        for (Integer bx : sameX.keySet()) {
            // b点坐标为：(bx,y)
            Integer bCount = sameX.get(bx);
            // 求出正方形的边
            int d = bx - x;
            if (d != 0) {
                // 寻找c点坐标，x相同
                if (!xMap.containsKey(bx)) {
                    continue;
                }
                // x相同的
                Map<Integer, Integer> someY = xMap.get(x);

                if (someY != null && someY.containsKey(y - d)) {
                    // 找d点
                    if (xMap.get(bx) != null &&
                            xMap.get(bx).containsKey(y - d)) {
                        // (x,y-d)
                        Integer c1 = someY.get(y - d);
                        // (bx,y-d)
                        Integer c2 = xMap.get(bx).get(y - d);
                        result += c1 * c2 * bCount;
                    }
                }
                // c点加正方形边长度，d点
                if (someY != null && someY.containsKey(y + d)) {
                    // 判断是否存在这样的点
                    if (xMap.get(bx) != null &&
                            xMap.get(bx).containsKey(y + d)) {
                        // (x,y+d)
                        Integer c1 = someY.get(y + d);
                        // (bx,y+d)
                        Integer c2 = xMap.get(bx).get(y + d);
                        result += c1 * c2 * bCount;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        System.out.println(detectSquares.count(new int[]{11, 10})); // 返回 1 。你可以选择：
        //   - 第一个，第二个，和第三个点
        System.out.println(detectSquares.count(new int[]{14, 8}));  // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
        detectSquares.add(new int[]{11, 2});    // 允许添加重复的点。
        System.out.println(detectSquares.count(new int[]{11, 10}));
    }
}