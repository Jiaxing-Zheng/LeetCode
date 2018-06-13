package Algorithms;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);
 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"
 Example 2:

 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:

 P     I    N
 A   L S  I G
 Y A   H R
 P     I
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) return s;
        StringBuilder[] array = new StringBuilder[numRows];
        for (int i = 0; i < array.length; i++) array[i] = new StringBuilder();
        int dir = 1;
        int index = 0;
        for (char c : s.toCharArray()) {
            array[index].append(c);
            index += dir;
            if (index == 0 || index == numRows - 1) dir = -dir;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) result.append(array[i]);
        return result.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion sol = new ZigZagConversion();
        System.out.println(sol.convert("PAYPALISHIRING", 4));
    }
}
