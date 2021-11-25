package cc.rcbb.leetcode.template;

/**
 * <p>
 * PrimeTemplate
 * </p>
 *
 * @author lvhao
 * @date 2021/11/25
 */
public class PrimeTemplate {

    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 暴力
     */
    public int primeCount(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println();
        return count;
    }

    public int primeCount2(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                System.out.print(i + " ");
                count++;
                for (int j = 2 * i; j < n; j = j + i) {
                    isPrime[j] = true;
                }
            }
        }
        System.out.println();
        return count;
    }

    public int primeCount3(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                System.out.print(i + " ");
                count++;
                for (int j = i * i; j < n; j = j + i) {
                    isPrime[j] = true;
                }
            }
        }
        System.out.println();
        return count;
    }

    public static void main(String[] args) {
        PrimeTemplate template = new PrimeTemplate();
        int r = template.primeCount(100);
        System.out.println(r);
        r = template.primeCount2(100);
        System.out.println(r);
        r = template.primeCount3(100);
        System.out.println(r);
    }

}
