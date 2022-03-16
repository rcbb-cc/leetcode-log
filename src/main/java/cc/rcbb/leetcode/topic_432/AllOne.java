package cc.rcbb.leetcode.topic_432;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 432. 全 O(1) 的数据结构
 * https://leetcode-cn.com/problems/all-oone-data-structure/
 */
class AllOne {

    private Node head;
    private HashMap<String, Node> map;

    public AllOne() {
        head = new Node();
        head.prev = head;
        head.next = head;
        map = new HashMap<>();
    }


    public void inc(String key) {
        if (map.containsKey(key)) {
            // 若key在链表中
            // key所在节点为cur
            Node cur = map.get(key);
            Node curNext = cur.next;
            // 若cur.next为空或cur.next.count>cur.count+1
            if (curNext == head || curNext.count > cur.count + 1) {
                //先插入一个count=cur.count+1的新节点到cur之后
                Node node = cur.insert(new Node(key, cur.count + 1));
                map.put(key, node);
            } else {
                curNext.keys.add(key);
                map.put(key, curNext);
            }
            // 最后，将key从cur.keys中移除
            cur.keys.remove(key);
            if (cur.keys.isEmpty()) {
                // 若cur.keys为空，则将cur从链表中移除
                cur.remove();
            }
        } else {
            // 若key不在链表中
            // 若链表为空或头节点的count>1
            if (head.next == head || head.next.count > 1) {
                // 插入一个count=1的新节点到链表头部
                Node node = head.insert(new Node(key, 1));
                map.put(key, node);
            } else {
                head.next.keys.add(key);
                map.put(key, head.next);
            }
        }
    }

    public void dec(String key) {
        Node cur = map.get(key);
        // key仅出现一次
        if (cur.count == 1) {
            // 直接移除
            cur.keys.remove(key);
            map.remove(key);
        } else {
            Node curPrev = cur.prev;
            // 若cur.prev为空或cur.prev.count<cur.count-1
            if (curPrev == head || curPrev.count < cur.count - 1) {
                // 先插入一个count=cur.count-1新节点到cur之前
                Node node = curPrev.insert(new Node(key, cur.count - 1));
                map.put(key, node);
            } else {
                curPrev.keys.add(key);
                map.put(key, curPrev);
            }
        }
        cur.keys.remove(key);
        if (cur.keys.isEmpty()) {
            cur.remove();
        }
    }

    public String getMaxKey() {
        if (head.prev != null) {
            return head.prev.keys.iterator().next();
        }
        return "";
    }

    public String getMinKey() {
        if (head.next != null) {
            return head.next.keys.iterator().next();
        }
        return "";
    }

    class Node {
        Set<String> keys;
        int count;
        Node prev;
        Node next;

        public Node() {
            this("", 0);
        }

        public Node(String key, int count) {
            this.count = count;
            this.keys = new HashSet<>();
            this.keys.add(key);
        }

        public Node insert(Node node) {
            node.prev = this;
            node.next = this.next;
            node.prev.next = node;
            node.next.prev = node;
            return node;
        }

        public void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    }

}

