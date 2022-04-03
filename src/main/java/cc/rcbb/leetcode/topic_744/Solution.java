package cc.rcbb.leetcode.topic_744;

/**
 * 744. 寻找比目标字母大的最小字母
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 */
class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right == n ? letters[0] : letters[left];
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        int n = letters.length;
        if (letters[n - 1] < target) {
            return letters[0];
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return letters[left];
    }

    public char nextGreatestLetter1(char[] letters, char target) {
        int n = letters.length;
        for (int i = 0; i < n; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }
        return letters[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入: letters = ["c", "f", "j"]，target = "a"
        //输出: "c"
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        //输入: letters = ["c","f","j"], target = "c"
        //输出: "f"
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        //输入: letters = ["c","f","j"], target = "d"
        //输出: "f"
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
    }
}