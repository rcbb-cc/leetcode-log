package cc.rcbb.leetcode.topic_460;

import java.util.HashMap;
import java.util.LinkedHashSet;

class LFUCache {

    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys = new HashMap<>();
    private HashMap<Integer, Integer> keyToVal = new HashMap<>();
    private HashMap<Integer, Integer> keyToFreq = new HashMap<>();
    private int minFreq = 0;
    private int cap;

    public LFUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (cap <= 0) {
            return -1;
        }
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        // keyToFreq 怎么处理？
        Integer freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        // freqToKeys 怎么处理？
        LinkedHashSet<Integer> set = freqToKeys.get(freq);
        if (set != null) {
            set.remove(key);
        }

        LinkedHashSet<Integer> newSet = freqToKeys.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
        }
        newSet.add(key);
        freqToKeys.put(freq + 1, newSet);
        // keyToVal 怎么处理？
        Integer result = keyToVal.get(key);
        // minFreq 怎么处理？
        if (minFreq == freq) {
            if (set.size() == 0) {
                minFreq++;
            }
        }
        return result;
    }

    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
        if (keyToVal.containsKey(key)) {
            // 存在这个key

            // keyToFreq 怎么处理？
            Integer freq = keyToFreq.get(key);
            keyToFreq.put(key, freq + 1);
            // freqToKeys 怎么处理？
            LinkedHashSet<Integer> set = freqToKeys.get(freq);
            if (set != null) {
                set.remove(key);
            }

            LinkedHashSet<Integer> newSet = freqToKeys.get(freq + 1);
            if (newSet == null) {
                newSet = new LinkedHashSet<>();
            }
            newSet.add(key);
            freqToKeys.put(freq + 1, newSet);
            // keyToVal 怎么处理？
            keyToVal.put(key, value);
            // minFreq 怎么处理？
            if (freq == minFreq) {
                if (set.size() == 0) {
                    minFreq = freq + 1;
                }
            }
        } else {
            if (keyToVal.size() >= cap) {
                // 删除最少次数的
                // freqToKeys 怎么处理？
                LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);
                Integer removeKey = null;
                if (keys != null) {
                    removeKey = keys.iterator().next();
                    keys.remove(removeKey);
                }
                // keyToFreq 怎么处理？
                keyToFreq.remove(removeKey);
                // keyToVal 怎么处理？
                keyToVal.remove(removeKey);
                // minFreq 怎么处理？
                if (keys != null && keys.size() == 0) {
                    minFreq--;
                    while (freqToKeys.get(minFreq) != null && freqToKeys.get(minFreq).size() > 0) {
                        minFreq--;
                    }
                }
            }
            // keyToFreq 怎么处理？
            // minFreq 怎么处理？
            minFreq = 1;
            keyToFreq.put(key, minFreq);
            // freqToKeys 怎么处理？
            LinkedHashSet<Integer> newSet = freqToKeys.get(minFreq);
            if (newSet == null) {
                newSet = new LinkedHashSet<>();
            }
            newSet.add(key);
            freqToKeys.put(minFreq, newSet);
            // keyToVal 怎么处理？
            keyToVal.put(key, value);

        }
    }

    public static void main(String[] args) {

        // ["LFUCache","put","put","put","put","get"]
        // [[2],[3,1],[2,1],[2,2],[4,4],[2]]
        // [null,null,null,null,null,2]
        /*LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(3, 1);
        lFUCache.put(2, 1);
        lFUCache.put(2, 2);
        lFUCache.put(4, 4);
        int r = lFUCache.get(2);
        System.out.println(r);*/

        // ["LFUCache","put","get"]
        // [[0],[0,0],[0]]
        // [null,null,-1]


        /*// ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
        // [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
        // [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
        LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
        lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        int r = lFUCache.get(1);// 返回 1
        System.out.println(r);
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        r = lFUCache.get(2);// 返回 -1（未找到）
        System.out.println(r);
        r = lFUCache.get(3);      // 返回 3
        System.out.println(r);
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        r = lFUCache.get(1);      // 返回 -1（未找到）
        System.out.println(r);
        r = lFUCache.get(3);      // 返回 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(r);
        r = lFUCache.get(4);      // 返回 4
        // cache=[3,4], cnt(4)=2, cnt(3)=3
        System.out.println(r);*/


    }
}
