package cc.rcbb.leetcode.topic_2043;

/**
 * 2043. 简易银行系统
 * https://leetcode-cn.com/problems/simple-bank-system/
 */
class Bank {
    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 < 1 || account1 > balance.length ||
                account2 < 1 || account2 > balance.length) {
            return false;
        }
        long m1 = this.balance[account1 - 1];
        if (m1 < money) {
            return false;
        }
        this.balance[account1 - 1] = m1 - money;
        this.balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account < 1 || account > balance.length) {
            return false;
        }
        this.balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account < 1 || account > balance.length) {
            return false;
        }
        if (this.balance[account - 1] < money) {
            return false;
        }
        this.balance[account - 1] -= money;
        return true;
    }
}