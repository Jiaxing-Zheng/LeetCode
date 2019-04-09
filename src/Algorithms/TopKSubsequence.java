package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skuang
 */
public class TopKSubsequence {
    List<String> topKSubsequence(String s, int k) {
        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty()) return result;
        if (k > s.length()) return result;
        char[] array = new char[k];
        int last = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = s.charAt(last);
            last++;
            for (int j = last + 1; j < s.length(); j++) {
                if (s.length() - j >= k - i && s.charAt(j) < array[i]) {
                    array[i] = s.charAt(j);
                    last = j + 1;
                }
            }
        }
        result.add(new String(array));
        return result;
    }

    public static void main(String[] args) {
        TopKSubsequence sol = new TopKSubsequence();
        System.out.println(sol.topKSubsequence("abddsfdbsc", 3));
    }
}
