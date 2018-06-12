package Algorithms;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".

 Example 1:

 Input: ["flower","flow","flight"]
 Output: "fl"
 Example 2:

 Input: ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.
 Note:

 All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (String s : strs) {
            while (s.indexOf(prefix) != 0) prefix = prefix.substring(0, prefix.length() - 1);
        }
        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        String word1 = strs[0];
        String word2 = strs[strs.length - 1];
        while (word2.indexOf(word1) != 0) {
            word1 = word1.substring(0, word1.length() - 1);
        }
        return word1;
    }

    public static void main(String[] args) {
        LongestCommonPrefix sol = new LongestCommonPrefix();
        System.out.println(sol.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(sol.longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
    }
}
