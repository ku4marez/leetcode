package misc;

import java.util.Arrays;

public class MathAlgorithm {
    public static void main(String[] args) {
        System.out.println(gcd(12, 18));
        System.out.println(lcm(12, 18));
        System.out.println(sumOfN(10));
        System.out.println(sumOfNSquares(3));
        System.out.println(computeMod(2, 10, 1000));
        System.out.println(prefixSum(new int[]{1, 2, 3, 4, 5}, 1, 3));
        System.out.println(findUnique(new int[]{1, 2, 2, 1, 3}));
        System.out.println(count1s(15));
        System.out.println(nCr(5, 2));
        int[] masks = generateSubsetsBitmask(3); // Outputs [0, 1, 2, ..., 7]
        System.out.println(Arrays.toString(masks));
        System.out.println(nCoins(8));
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private static int sumOfN(int n) {
        return n * (n + 1) / 2;
    }

    private static int sumOfNSquares(int n) {
        return n * (n + 1) * (2 * n + 1) / 6;
    }

    private static int computeMod(int a, int b, int mod) {
        long result = 1, base = a % mod;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            b >>= 1;
        }
        return (int) result;
    }

    private static int nCr(int n, int m) {
        int MOD = 1_000_000_007;
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = (fact[i - 1] * i) % MOD;
        long numerator = fact[n];
        long denominator = (fact[m] * fact[n - m]) % MOD;
        long inverse = computeMod((int) denominator, MOD - 2, MOD);
        return (int) ((numerator * inverse) % MOD);
    }

    private static int nCoins(int n) {
        int low = 0, high = n, res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            long coinsUsed = (long) mid * (mid + 1) / 2;
            if (coinsUsed <= n) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private static int prefixSum(int[] arr, int n, int m) {
        if(n == 0) return 0;
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = 0;
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum[m] - prefixSum[n - 1];
    }

    private static int findUnique(int[] arr) {
        int xor = 0;
        for (int i : arr) {
            xor ^= i;
        }
        return xor;
    }

    private static int count1s(int n) {
        int count = 0;
        System.out.println(Integer.toBinaryString(n));
        while(n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    private static int[] generateSubsetsBitmask(int n) {
        int[] result = new int[1 << n];
        for(int i = 0; i < (1 << n); i++) {
            result[i] = i;
        }
        return result;
    }

}
