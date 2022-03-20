package cc.rcbb.leetcode.topic_146;

import java.util.HashMap;
import java.util.Map;
/**
 * 146. LRU 缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 */
class LRUCache {

    Node head;
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        head.next = head;
        head.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // 将其移动到最前面
            Node cur = map.get(key);
            // 先将自己删除
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            // 构造自己
            Node node = new Node(key, cur.value);
            node.prev = head;
            node.next = head.next;
            node.next.prev = node;
            node.prev.next = node;
            map.put(key, node);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 如果key在链表中存在
        if (map.containsKey(key)) {
            // 将其移动到最前面
            Node cur = map.get(key);
            // 先将自己删除
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            // 构造自己
            Node node = new Node(key, value);
            node.prev = head;
            node.next = head.next;
            node.next.prev = node;
            node.prev.next = node;
            map.put(key, node);
        } else {
            // key在链表中不存在
            // 成为首节点
            Node node = new Node(key, value);
            node.prev = head;
            node.next = head.next;
            node.next.prev = node;
            node.prev.next = node;
            map.put(key, node);
            // size+1 判断是否大于容量
            if (size + 1 > capacity) {
                // 删除最后一个
                Node last = head.prev;
                map.remove(last.key);
                last.prev.next = last.next;
                last.next.prev = last.prev;
            }
            size++;
        }
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
            this.value = -1;
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}