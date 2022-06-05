package cc.rcbb.leetcode.topic_929;

import java.util.HashMap;
import java.util.Map;

/**
 * 929. 独特的电子邮件地址
 * https://leetcode.cn/problems/unique-email-addresses/
 */
class Solution {
    public int numUniqueEmails(String[] emails) {
        Map<String, Integer> map = new HashMap<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            int j = 0;
            for (int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
                if (c == '@') {
                    flag = false;
                    j = i;
                    break;
                }
                if (flag || c == '.') {
                    continue;
                }
                if (c == '+') {
                    flag = true;
                } else {
                    sb.append(c);
                }
            }
            sb.append(email.substring(j));
            String key = sb.toString();
            map.put(key, 1);
        }
        return map.size();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
        System.out.println(solution.numUniqueEmails(new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"}));
    }
}