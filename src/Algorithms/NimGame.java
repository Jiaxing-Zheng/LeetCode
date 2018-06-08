package Algorithms;

/**
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

 Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

 Example:

 Input: 4
 Output: false
 Explanation: If there are 4 stones in the heap, then you will never win the game;
 No matter 1, 2, or 3 stones you remove, the last stone will always be
 removed by your friend.
 */
public class NimGame {

    public boolean canWinNim(int n) {
        if (n < 4) return true;
        boolean[] array = new boolean[n + 1];
        array[n] = true;
        for (int i = n - 1; i > 0; i--) {
            if (!check(array, i + 1) || !check(array, i + 2) || !check(array, i + 3)) {
                array[i] = true;
            }
        }
        return array[1];
    }
    public boolean check(boolean[] array, int i) {
        if (i >= array.length) return false;
        return array[i];
    }

    public boolean canWinNim1(int n) {
        return (n % 4) != 0;
    }

    public static void main(String[] args) {
        NimGame sol = new NimGame();
        System.out.println(sol.canWinNim(4));
    }
}
