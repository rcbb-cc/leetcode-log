package cc.rcbb.leetcode.topic_146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 */
class LRUCache {

    private LinkedHashMap<Integer, Integer> cache;
    private int cap;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };
        this.cap = capacity;
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

}
