package Algorithms;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.

 Example 1:

 Input: 1
 Output: "1"
 Example 2:

 Input: 4
 Output: "1211"
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String result = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < result.length();) {
                char curr = result.charAt(j);
                int count = 0;
                while (j < result.length() && result.charAt(j) == curr) {
                    count++;
                    j++;
                }
                sb.append(count);
                sb.append(curr);
            }
            result = sb.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        CountAndSay sol = new CountAndSay();
        System.out.println(sol.countAndSay(5));
    }
}
