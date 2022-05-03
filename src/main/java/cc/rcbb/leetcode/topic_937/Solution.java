package cc.rcbb.leetcode.topic_937;


import java.util.Arrays;

/**
 * 937. 重新排列日志文件
 * https://leetcode-cn.com/problems/reorder-data-in-log-files/
 */
class Solution {
    /**
     * 自定义排序
     * <p>
     * 1.字母日志始终小于数字日志。
     * 2.数字日志保留原来的相对顺序。
     * 3.字母日志进行相互比较时，先比较第二部分的大小。如果相等，则比较标识符大小。比较时都使用字符串的比较方式。
     *
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
        int length = logs.length;
        Pair[] arr = new Pair[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Pair(logs[i], i);
        }
        Arrays.sort(arr, (a, b) -> logCompare(a, b));
        String[] res = new String[length];
        for (int i = 0; i < length; i++) {
            res[i] = arr[i].log;
        }
        return res;
    }

    /**
     * @param pair1 输入log1
     * @param pair2 输入log2
     * @return 0：相等；1：pair1大；-1：pair2大；
     */
    public int logCompare(Pair pair1, Pair pair2) {
        String log1 = pair1.log;
        String log2 = pair2.log;
        int index1 = pair1.index;
        int index2 = pair2.index;

        String[] split1 = log1.split(" ", 2);
        String[] split2 = log2.split(" ", 2);
        boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
        boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
        // 全是数字日志
        if (isDigit1 && isDigit2) {
            // 按相对顺序
            return index1 - index2;
        }
        // 全是字母日志
        if (!isDigit1 && !isDigit2) {
            // 取内容进行比较
            int sc = split1[1].compareTo(split2[1]);
            // 内容不同
            if (sc != 0) {
                return sc;
            }
            // 内容相同，取标识符进行比较
            return split1[0].compareTo(split2[0]);
        }
        // 数字大，字母小
        return isDigit1 ? 1 : -1;
    }

}

class Pair {
    String log;
    int index;

    public Pair(String log, int index) {
        this.log = log;
        this.index = index;
    }
}