package cc.rcbb.leetcode.topic_2013;

import java.util.HashMap;
import java.util.Map;

/**
 * 2013. 检测正方形
 * https://leetcode-cn.com/problems/detect-squares/
 */
class DetectSquares {

    private Map<Integer, Map<Integer, Integer>> colMap;
    private Map<Integer, Map<Integer, Integer>> rowMap;

    public DetectSquares() {
        colMap = new HashMap<>();
        rowMap = new HashMap<>();
    }

    public void add(int[] point) {
        int col = point[0];
        int row = point[1];
        Map<Integer, Integer> colM = colMap.getOrDefault(col, new HashMap<>());
        colM.put(row, colM.getOrDefault(row, 0) + 1);
        colMap.put(col, colM);
        Map<Integer, Integer> rowM = rowMap.getOrDefault(row, new HashMap<>());
        rowM.put(col, colM.getOrDefault(col, 0) + 1);
        rowMap.put(row, rowM);
    }

    public int count(int[] point) {
        int col = point[0];
        int row = point[1];
        int result = 0;
        if (!colMap.containsKey(col)) {
            return 0;
        }
        Map<Integer, Integer> rolM = colMap.get(col);
        for (int tempRow : rolM.keySet()) {
            Integer rolCount = rolM.get(tempRow);
            int dis = tempRow - row;
            if (dis != 0) {

                if (!rowMap.containsKey(row)) {
                    continue;
                }
                Map<Integer, Integer> colM = rowMap.get(row);
                if (colM.containsKey(col + dis)) {
                    if (rowMap.get(tempRow) != null && rowMap.get(tempRow).containsKey(col + dis)) {
                        Integer c1 = colM.get(col + dis);
                        Integer c2 = rowMap.get(tempRow).get(col + dis);
                        result += rolCount * c1 * c2;
                    }
                }
                if (colM.containsKey(col - dis)) {
                    if (rowMap.get(tempRow) != null && rowMap.get(tempRow).containsKey(col - dis)) {
                        Integer c1 = colM.get(col - dis);
                        Integer c2 = rowMap.get(tempRow).get(col - dis);
                        result += rolCount * c1 * c2;
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