package Algorithms;

import java.util.Arrays;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n + 1][n + 1];
        String max = "";
        for (int j = 0; j < n + 1; j++) { // i == 0; j == 2
            for (int i = j; i >= 0; i--) {
                if (i == j || i + 1 == j) {
                    isPalindrome[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j - 1) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                }

                if (i != j && isPalindrome[i][j] && max.length() < j - i) {
                    max = s.substring(i, j);
                }
            }

        }
        return max;
    }









    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        String max = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s.substring(i, j + 1)) && j - i + 1 > max.length()) {
                    max = s.substring(i, j + 1);
                }
            }
        }
        return max;
    }

    private boolean isPalindrome(String s) {
        String d = new StringBuilder(s).reverse().toString();
        return s.equals(d);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
//        System.out.println(sol.longestPalindrome2("abbc"));
        System.out.println(sol.longestPalindrome("abbfsbvcccc"));
    }
}
