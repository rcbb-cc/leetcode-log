package cc.rcbb.leetcode.topic_811;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. 子域名访问计数
 * https://leetcode.cn/problems/subdomain-visit-count/
 */
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] arr = domain.split(" ");
            Integer count = Integer.valueOf(arr[0]);
            String path = arr[1];
            String[] pathArray = path.split("\\.");
            int length = pathArray.length;
            for (int i = 0; i < length; i++) {
                StringBuilder key = new StringBuilder();
                for (int j = i; j < length; j++) {
                    key.append(pathArray[j]);
                    if (j != length - 1) {
                        key.append(".");
                    }
                }
                map.put(key.toString(), map.getOrDefault(key.toString(), 0) + count);
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
        System.out.println(strings);
    }

}