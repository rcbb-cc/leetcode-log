package cc.rcbb.leetcode.topic_535;


import java.util.HashMap;
import java.util.Map;

/**
 * 535. TinyURL 的加密与解密
 * https://leetcode.cn/problems/encode-and-decode-tinyurl/
 */
public class Codec {

    private Integer count = 0;
    Map<Integer, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int i = longUrl.lastIndexOf("/");
        String base = longUrl.substring(0, i);
        String value = longUrl.substring(i + 1);
        map.put(count, value);
        return base + "/" + count++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int i = shortUrl.lastIndexOf("/");
        String base = shortUrl.substring(0, i);
        Integer key = Integer.parseInt(shortUrl.substring(i + 1));
        return base + "/" + map.get(key);
    }

    public static void main(String[] args) {
        Codec solution = new Codec();
        // 输入：url = "https://leetcode.com/problems/design-tinyurl"
        // 输出："https://leetcode.com/problems/design-tinyurl"
        System.out.println(solution.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(solution.decode("https://leetcode.com/problems/0"));
    }
}
