package algorithm;

public class BitOperations {
    // XOR for Missing Number
    public static int missingNumber(int[] nums) {
        int xor = 0, n = nums.length;

        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }

        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }

    // XOR for Single Number
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    // Bit Manipulation for Counting Set Bits
    public static int hammingWeight(int n) {
        int count = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1; // Right shift to check the next bit
        }

        return count;
    }

    // Hamming distance. Counting set of different bits between two numbers
    public static int hammingDistance(int x, int y) {
        int result = x ^ y;
        return Integer.bitCount(result);
    }

    // Bit Manipulation for Reversing Bits
    public static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // Extract the LSB (least significant bit)
            int bit = n & 1;

            // Shift result left and add the extracted bit
            result = (result << 1) | bit;

            // Shift n right to process the next bit
            n = n >> 1;
        }

        return result;
    }

    // Bit Manipulation to Check Power of Two
    public static boolean isPowerOfTwo(int n) {
        return (n != 0) && ((n & (n - 1)) == 0);
    }

    // Iterative division
    public static boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    // Bit Manipulation to Check Power of Four. 0xAAAAAAAA: Binary mask where all even bits are set to 1.
    public static boolean isPowerOfFour(int n) {
        // Check power of 2 and odd-positioned set bit
        return (n > 0) && ((n & (n - 1)) == 0) && ((n & 0xAAAAAAAA) == 0);
    }

    // Bit Manipulation using XOR to cancel out duplicate characters
    public static char findTheDifference(String s, String t) {
        char result = 0;

        for (char c : s.toCharArray()) {
            result ^= c;
        }

        for (char c : t.toCharArray()) {
            result ^= c;
        }

        return result;
    }

    // Number complement in a binary representation
    public static int findComplement(int num) {
        int mask = Integer.highestOneBit(num << 1) - 1;
        return num ^ mask;
    }

    // Recursive approach
    public static char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");
        while (word.length() < k) {
            StringBuilder generated = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                generated.append((char) ((word.charAt(i) - 'a' + 1) % 26 + 'a'));
            }
            word.append(generated);
        }
        return word.charAt(k - 1);
    }
}
