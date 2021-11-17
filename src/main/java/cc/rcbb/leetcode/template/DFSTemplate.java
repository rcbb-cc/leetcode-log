package cc.rcbb.leetcode.template;

/**
 * <p>
 * DFSTemplate
 * </p>
 *
 * @author lvhao
 * @date 2021/11/17
 */
public class DFSTemplate {

    public void backtrack() {
        /**
         * result = []
         * def backtrack(路径, 选择列表):
         *      if 满足结束条件:
         *          result.add(路径)
         *          return
         *      for 选择 in 选择列表:
         *          做选择
         *          backtrack(路径, 选择列表)
         *          撤销选择
         */


        /**
         * 回溯算法的核心框架
         *
         * for 选择 in 选择列表:
         *      # 做选择
         *      将该选择从选择列表移出
         *      路径.add(选择)
         *      backtrack(路径, 选择列表)
         *      # 撤销选择
         *      路径.remove(选择)
         *      将该选择再加入选择列表
         */
    }

}
