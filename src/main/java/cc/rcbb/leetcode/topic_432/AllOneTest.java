package cc.rcbb.leetcode.topic_432;

public class AllOneTest {
    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        String maxKey = allOne.getMaxKey();// 返回 "hello"
        System.out.println(maxKey);
        String minKey = allOne.getMinKey();// 返回 "hello"
        System.out.println(minKey);
        allOne.inc("leet");
        maxKey = allOne.getMaxKey(); // 返回 "hello"
        System.out.println(maxKey);
        minKey = allOne.getMinKey(); // 返回 "leet"
        System.out.println(minKey);
        allOne.dec("hello");
        minKey = allOne.getMinKey(); // 返回 "leet"
        System.out.println(minKey);
        allOne.dec("hello");
        minKey = allOne.getMinKey(); // 返回 "leet"
        System.out.println(minKey);
        allOne.dec("leet");
        minKey = allOne.getMinKey(); // 返回 "leet"
        System.out.println(minKey);
    }

}
