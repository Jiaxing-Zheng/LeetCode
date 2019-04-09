package Algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author skuang
 */
public class BlackJackPossibility {
    public static double blackJackPossibility1() {
        double result = 0;
        double sum = 1;
        double[] p = new double[22];
        p[0] = 1;
        for (int i = 1; i <= 21; i++) {
            p[i] = sum / 10;
            sum += p[i];
            if (i >= 17) result += p[i];
            if (i >= 10) sum -= p[i - 10];
        }
        return result;
    }

    public static double blackJackPossibility2() {
        Map<Integer, Integer> total = new HashMap<>();
        Map<Integer, Integer> pass = new HashMap<>();
        dfs(0, total, pass);
        System.out.println("pass: " + pass.get(0) + " total: " + total.get(0));
        return (double) pass.get(0) / total.get(0);
    }

    private static int[] dfs(int curr, Map<Integer, Integer> total,
            Map<Integer, Integer> pass) {
        if (curr >= 17 && curr <= 21) {
            return new int[] {1, 1};
        } else if (curr > 21) {
            return new int[] {0, 1};
        }
        if (total.containsKey(curr)) {
            return new int[] {pass.get(curr), total.get(curr)};
        }
        int[] res = new int[2];
        for (int n = 1; n <= 10; n++) {
            int[] r = dfs(curr + n, total, pass);
            res[0] += r[0];
            res[1] += r[1];
        }
        total.put(curr, res[1]);
        pass.put(curr, res[0]);
        return new int[] {pass.get(curr), total.get(curr)};
    }

    public static void main(String[] args) {
        System.out.println(blackJackPossibility1());
        System.out.println(blackJackPossibility2());
    }
}
