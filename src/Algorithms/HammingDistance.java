package Algorithms;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

 Note:
 0 ≤ x, y < 2^31.

 Example:

 Input: x = 1, y = 4

 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    public static void main(String[] args) {
        HammingDistance sol = new HammingDistance();
        System.out.println(sol.hammingDistance(1,4));
    }
}
