package Algorithms;

/**
 * Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".

 Time: O(n)
 Space: depends on language using
 Java: O(n)
 C, C++: O(1)
 */
public class StringReverse {

    public static String reverseString(String s) {
        if (s == null ||s.length() == 0) return s;
        char[] array = s.toCharArray();
        for (int left = 0, right = array.length - 1; left < right; left++, right--) {
            swap(array, left, right);
        }
        return new String(array);
    }

    public static void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }
}
