package Algorithms;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.

 Credits:
 Special thanks to @fujiaozhu for adding this problem and creating all test cases.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int add = (a & b) << 1;
            a = a ^ b;
            b = add;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers sol = new SumOfTwoIntegers();
        System.out.println(sol.getSum(5,6));
    }
}
