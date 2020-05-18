package Algorithms;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    public static int totalFruit(int[] tree) {
        if (tree.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < tree.length; right++) {
            map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);
            while (map.size() > 2) {
                if (map.get(tree[left]) == 1) {
                    map.remove(tree[left]);
                } else {
                    map.put(tree[left], map.get(tree[left]) - 1);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(FruitsIntoBaskets.totalFruit(new int[] {1,2,3,2,2}));
    }
}
