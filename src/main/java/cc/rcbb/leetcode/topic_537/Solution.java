package cc.rcbb.leetcode.topic_537;

/**
 * 537. 复数乘法
 * https://leetcode-cn.com/problems/complex-number-multiplication/
 */
class Solution {
    /**
     * 本题考察的是「复数乘法法则」运用。
     * 根据 (a+bi)(c+di) =(ac−bd)+(bc+ad)i
     * <p>
     * 这里可以直接使用String的split()方法，使用正则表达式进行切割字符串
     * 因为复数的格式是固定的，都是 real + imag * i
     * 其中的**"+" 与 "i"**是不变的，所以可以通过这两个字符来写正则表达式
     * "\\+ | i"，其中"\\"是转义，"|"是或者
     */
    public String complexNumberMultiply(String num1, String num2) {
        String[] ss1 = num1.split("\\+|i");
        String[] ss2 = num2.split("\\+|i");
        int a = Integer.parseInt(ss1[0]);
        int b = Integer.parseInt(ss1[1]);
        int c = Integer.parseInt(ss2[0]);
        int d = Integer.parseInt(ss2[1]);
        int A = a * c - b * d;
        int B = b * c + a * d;
        return A + "+" + B + "i";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //输入：num1 = "1+1i", num2 = "1+1i"
        //输出："0+2i"
        //解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
        System.out.println(solution.complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(solution.complexNumberMultiply("1+-1i", "1+-1i"));
    }
}