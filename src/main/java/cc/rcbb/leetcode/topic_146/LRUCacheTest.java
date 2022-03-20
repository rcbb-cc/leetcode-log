package cc.rcbb.leetcode.topic_146;

public class LRUCacheTest {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        int r = lRUCache.get(1);// 返回 1
        System.out.println(r);
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        r = lRUCache.get(2);    // 返回 -1 (未找到)
        System.out.println(r);
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        r = lRUCache.get(1);    // 返回 -1 (未找到)
        System.out.println(r);
        r = lRUCache.get(3);    // 返回 3
        System.out.println(r);
        r = lRUCache.get(4);    // 返回 4
        System.out.println(r);
    }

}
