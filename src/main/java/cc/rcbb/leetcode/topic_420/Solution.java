package cc.rcbb.leetcode.topic_420;

/**
 * 420. 强密码检验器
 * https://leetcode-cn.com/problems/strong-password-checker/
 */
class Solution {
    /**
     * 长度小于6
     * 删除和替换无意义。
     * 因此，该操作的次数为 6 - n 与 3 - (字符种类) 中的较大值，即需要保证字符串长度和字符种类均满足要求。
     * <p>
     * 6<=长度<=20
     * 添加和删除无意义。
     * 对于连续的k个相同的字符，我们可以替换其中k/3个，使得不存在3个连续相同的字符（即每数 3 个字符就替换一次）。
     * 同时，我们还需要保证最终字符串包含全部的3类字符，因此替换操作的次数为（所有的k/3之和）与3-(字符种类)中的较大值。
     * <p>
     * 长度>=20
     * 添加无意义。
     * 需要分别求出，替换和删除需要的次数。
     * 替换：所有的k/3之和
     * 删除：在删除的过程中，连续相同的字符串数量也会变少。
     * 根据 k mod 3 的值的不同，有一下几种情况。
     * k mod 3==0，删除1个字符后，k/3的值会减少1，随后每删除3个字符，k/3的值会再减少1。
     * k mod 3==1，删除2个字符后，k/3的值会减少1，随后每删除3个字符，k/3的值会再减少1。
     * k mod 3==2，那么每删除 3 个字符的值会减少 1.
     * 因此在删除字符时，我们优先从所有k mod 3==0的连接相同字符组中删除1个字符，
     * 其次从删除k mod 3==1的连续相同字符组中删除2个字符，
     * 最后每删除3个字符。
     * <p>
     * 最终删除一个字符需要的次数为：n-20
     * 替换一个字符所需的次数为：(所有的 k/3 之和)
     */
    public int strongPasswordChecker(String password) {
        int n = password.length();
        int hasLower = 0, hasUpper = 0, hasDigit = 0;
        for (int i = 0; i < n; ++i) {
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                hasLower = 1;
            } else if (Character.isUpperCase(ch)) {
                hasUpper = 1;
            } else if (Character.isDigit(ch)) {
                hasDigit = 1;
            }
        }
        int categories = hasLower + hasUpper + hasDigit;

        if (n < 6) {
            return Math.max(6 - n, 3 - categories);
        } else if (n <= 20) {
            int replace = 0;
            int cnt = 0;
            char cur = '#';

            for (int i = 0; i < n; ++i) {
                char ch = password.charAt(i);
                if (ch == cur) {
                    ++cnt;
                } else {
                    replace += cnt / 3;
                    cnt = 1;
                    cur = ch;
                }
            }
            replace += cnt / 3;
            return Math.max(replace, 3 - categories);
        } else {
            // 替换次数和删除次数
            int replace = 0, remove = n - 20;
            // k mod 3 = 1 的组数，即删除 2 个字符可以减少 1 次替换操作
            int rm2 = 0;
            int cnt = 0;
            char cur = '#';

            for (int i = 0; i < n; ++i) {
                char ch = password.charAt(i);
                if (ch == cur) {
                    ++cnt;
                } else {
                    if (remove > 0 && cnt >= 3) {
                        if (cnt % 3 == 0) {
                            // 如果是 k % 3 = 0 的组，那么优先删除 1 个字符，减少 1 次替换操作
                            --remove;
                            --replace;
                        } else if (cnt % 3 == 1) {
                            // 如果是 k % 3 = 1 的组，那么存下来备用
                            ++rm2;
                        }
                        // k % 3 = 2 的组无需显式考虑
                    }
                    replace += cnt / 3;
                    cnt = 1;
                    cur = ch;
                }
            }
            if (remove > 0 && cnt >= 3) {
                if (cnt % 3 == 0) {
                    --remove;
                    --replace;
                } else if (cnt % 3 == 1) {
                    ++rm2;
                }
            }
            replace += cnt / 3;

            // 使用 k % 3 = 1 的组的数量，由剩余的替换次数、组数和剩余的删除次数共同决定
            int use2 = Math.min(Math.min(replace, rm2), remove / 2);
            replace -= use2;
            remove -= use2 * 2;
            // 由于每有一次替换次数就一定有 3 个连续相同的字符（k / 3 决定），因此这里可以直接计算出使用 k % 3 = 2 的组的数量
            int use3 = Math.min(replace, remove / 3);
            replace -= use3;
            remove -= use3 * 3;
            return (n - 20) + Math.max(replace, 3 - categories);
        }
    }
}