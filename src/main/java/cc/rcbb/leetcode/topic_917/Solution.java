package cc.rcbb.leetcode.topic_917;

/**
 * 917. 仅仅反转字母
 * https://leetcode-cn.com/problems/reverse-only-letters/
 */
class Solution {
    public String reverseOnlyLetters1(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        int left = 0;
        int right = n - 1;
        while (true) {
            while (left < right &&
                    !Character.isLetter(array[left])) {
                left++;
            }
            while (right > left &&
                    !Character.isLetter(array[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
        return new String(array);
    }

    public String reverseOnlyLetters(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            if (!Character.isLetter(array[i])) {
                res[i] = array[i];
            }
        }
        int end = n - 1;
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(array[i])) {
                while (end > 0 && res[end] != '\u0000') {
                    end--;
                }
                if (end < 0) {
                    continue;
                }
                res[end] = array[i];
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseOnlyLetters("ab-cd"));
        System.out.println(solution.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(solution.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}