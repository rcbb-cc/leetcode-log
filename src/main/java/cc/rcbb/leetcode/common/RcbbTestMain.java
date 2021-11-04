package cc.rcbb.leetcode.common;

/**
 * <p>
 * RcbbTestMain
 * </p>
 *
 * @author lvhao
 * @date 2021/11/4
 */
public class RcbbTestMain {

    public static void main(String[] args) {

        //String str = "ab";
        //String str = "aba";
        //String str = "abba";
        String str = "ababc";
        //String str = "abcdef";
        //String str = "abccbb";
        //RcbbTestMain.check(str);


        //int flag = str.length() % 2;
        //int middle = str.length() / 2;
        //if (flag == 0) {
        //    String palindrome = RcbbTestMain.palindrome(str, middle - 1, middle);
        //    System.out.println(palindrome);
        //} else {
        //    String palindrome = RcbbTestMain.palindrome(str, middle, middle);
        //    System.out.println(palindrome);
        //}

        System.out.println(RcbbTestMain.longestPalindrome(str));

    }

    public static boolean check(String str) {
        char[] strArray = str.toCharArray();
        int length = str.length();
        int middle = str.length() / 2;
        for (int i = 0; i < middle; i++) {
            System.out.println(strArray[i] + " = " + strArray[length - i - 1]);
            if (strArray[i] != strArray[length - i - 1]) {
                //return false;
            }
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            String tmpStr = s1.length() > s2.length() ? s1 : s2;
            res = res.length() > tmpStr.length() ? res : tmpStr;
        }
        return res;
    }

    public static String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
