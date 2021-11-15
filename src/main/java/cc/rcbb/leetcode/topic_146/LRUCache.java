package cc.rcbb.leetcode.topic_146;

import java.util.LinkedHashMap;

/**
 * 146. LRU 缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 */
class LRUCache {

    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Integer result = map.get(key);
        map.remove(key);
        map.put(key, result);
        return result;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
        if (map.size() >= cap) {
            Integer firstKey = map.keySet().iterator().next();
            map.remove(firstKey);
        }
        map.put(key, value);
    }

}
