package cc.rcbb.leetcode.common;

import java.util.LinkedList;

public class TrieTree {

    class TrieNode {
        TrieNode preNode = null;
        boolean isEnd = false;
        int deep = 0;
        char content = 0;
        LinkedList<TrieNode> child = new LinkedList<>();




    }


}
