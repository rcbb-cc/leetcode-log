package cc.rcbb.leetcode.topic_96;

/**
 * <p>
 * Solution1
 * </p>
 *
 * @author lvhao
 * @date 2021/12/3
 */
public class Solution1 {

    /**
     * 会超出时间限制，因为会有重复计算。
     */
    int numTrees(int n) {
        // 计算闭区间[1,n]组成的BST个数
        return count(1, n);
    }
    int count(int start, int end) {
        if (start > end) {
            return 1;
        }
        int res = 0;
        for (int i = start; i <= end; i++) {
            // 以i值作为根节点
            int left = count(start, i - 1);
            int right = count(i + 1, end);
            // 左右子树的组合数乘积是BST的总数
            res += left*right;
        }
        return res;
    }

}
