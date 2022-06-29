package cc.rcbb.leetcode.topic_535;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 535. TinyURL 的加密与解密
 * https://leetcode.cn/problems/encode-and-decode-tinyurl/
 */
public class Codec1 {

    Map<String, String> origin2Tiny = new HashMap<>();
    Map<String, String> tiny2Origin = new HashMap<>();
    String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    String prefix = "https://leetcode.com/problems/";
    int k = 6;
    Random random = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (!origin2Tiny.containsKey(longUrl)) {
            char[] cs = new char[k];
            for (int i = 0; i < k; i++) {
                cs[i] = str.charAt(random.nextInt(str.length()));
                String cur = prefix + String.valueOf(cs);
                if (tiny2Origin.containsKey(cur)) {
                    continue;
                }
                tiny2Origin.put(cur, longUrl);
                origin2Tiny.put(longUrl, cur);
            }
        }
        return origin2Tiny.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tiny2Origin.get(shortUrl);
    }

    public static void main(String[] args) {
        Codec1 solution = new Codec1();
        // 输入：url = "https://leetcode.com/problems/design-tinyurl"
        // 输出："https://leetcode.com/problems/design-tinyurl"
        System.out.println(solution.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(solution.decode("https://leetcode.com/problems/7TYhl7"));
    }
}
