package cc.rcbb.leetcode.topic_1656;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656. 设计有序流
 * https://leetcode.cn/problems/design-an-ordered-stream/
 */
class OrderedStream {

    String[] arr;
    int ptr;
    int n;

    public OrderedStream(int n) {
        arr = new String[n + 1];
        ptr = 1;
        this.n = n + 1;
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        arr[idKey] = value;
        if (idKey == ptr) {
            for (int i = idKey; i < n; i++) {
                if (arr[i] == null) {
                    ptr = i;
                    break;
                }
                result.add(arr[i]);
            }
        }
        return result;
    }
}
