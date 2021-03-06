package Algorithms;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

 Example 1:

 Input: 121
 Output: true
 Example 2:

 Input: -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 Example 3:

 Input: 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 Follow up:

 Coud you solve it without converting the integer to a string?
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int n = 0;
        while (x > n) {
            n *= 10;
            n += x % 10;
            x /= 10;
        }
        return (x == n) || (n / 10 == x);
    }

    public static void main(String[] args) {
        PalindromeNumber sol = new PalindromeNumber();
        System.out.println(sol.isPalindrome(12321));
        System.out.println(sol.isPalindrome(123321));
        System.out.println(sol.isPalindrome(12345621));


    }
}
