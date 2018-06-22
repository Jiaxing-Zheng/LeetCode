package Algorithms;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output: 321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        int neg = x < 0 ? -1 : 1;
        x *= neg;
        int ret = 0;
        while (x > 0) {
            int n = ret;
            n *= 10;
            n += x % 10;
            x /= 10;
            if (n / 10 != ret) return 0;
            ret = n;
        }
        return ret * neg;
    }

    public static void main(String[] args) {
        ReverseInteger sol = new ReverseInteger();
        System.out.println(sol.reverse(-123));
    }
}
