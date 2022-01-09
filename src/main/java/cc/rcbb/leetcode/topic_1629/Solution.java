package cc.rcbb.leetcode.topic_1629;


/**
 * 1629. 按键持续时间最长的键
 * https://leetcode-cn.com/problems/slowest-key/
 */
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int max = releaseTimes[0];
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            int t = releaseTimes[i] - releaseTimes[i - 1];
            if (t > max) {
                max = t;
                maxIndex = i;
            } else if (t == max && keysPressed.charAt(i) > keysPressed.charAt(maxIndex)) {
                maxIndex = i;
            }
        }
        return keysPressed.charAt(maxIndex);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入：releaseTimes = [9,29,49,50], keysPressed = "cbcd"
        // 输出："c"
        System.out.println(solution.slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));
        // 输入：releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
        // 输出："a"
        System.out.println(solution.slowestKey(new int[]{12,23,36,46,62}, "spuda"));
        // [23,34,43,59,62,80,83,92,97]
        // "qgkzzihfc"
        System.out.println(solution.slowestKey(new int[]{23,34,43,59,62,80,83,92,97}, "qgkzzihfc"));
        // [23,34,43,59,62,80,83,92,97]
        // "qgkzzihfc"
        // q
        System.out.println(solution.slowestKey(new int[]{23, 34, 43, 59, 62, 80, 83, 92, 97}, "qgkzzihfc"));
    }
}