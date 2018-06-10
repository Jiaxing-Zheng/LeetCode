package Algorithms;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

 Note:

 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Example 1:

 Input: [2,2,1]
 Output: 1
 Example 2:

 Input: [4,1,2,1,2]
 Output: 4
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null) return 0;
        int num = 0;
        for (int n : nums) {
            num ^= n;
        }
        return num;
    }

    public static void main(String[] args) {
        SingleNumber sol = new SingleNumber();
        System.out.println(sol.singleNumber(new int[] {2,2,1}));
    }
}
