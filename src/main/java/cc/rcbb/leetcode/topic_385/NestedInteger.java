package cc.rcbb.leetcode.topic_385;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * NestedInteger
 * </p>
 *
 * @author lvhao
 * @date 2022/4/15
 */

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public class NestedInteger {

    Integer value;
    private List<NestedInteger> list;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
        list = new ArrayList<>();
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {

    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return null;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        this.value = value;
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        this.list.add(ni);
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return this.list;
    }

    @Override
    public String toString() {
        String s = "[" + this.value;
        for (NestedInteger ni : this.list) {
            s += "[" + ni.value + "]";
        }
        s += "]";
        return s;
    }
}
