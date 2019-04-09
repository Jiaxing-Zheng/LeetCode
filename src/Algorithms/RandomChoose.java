package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author skuang
 */
public class RandomChoose {

    private List<Item> items;
    private int[] sums;
    private Random rand = new Random();

    public RandomChoose(List<Item> items) {
        this.items = items;
        sums = new int[items.size()];
        int sum = 0;
        for (int i = 0; i < items.size(); i++) {
            sum += items.get(i).count;
            sums[i] = sum;
        }
    }

    public String weightedRand() {
        int randN = rand.nextInt(sums[sums.length - 1]);
        int index = Arrays.binarySearch(sums, randN);
        if (index >= 0) return items.get(index).name;
        return items.get(-(index + 1)).name;
    }



    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();
        list.add(new Item("Rami", 25));
        list.add(new Item("Mike", 10));
        list.add(new Item("Drew", 30));
        list.add(new Item("suja", 20));
        list.add(new Item("Howard", 15));




        RandomChoose sol = new RandomChoose(list);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            String name = sol.weightedRand();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "   " + (double) entry.getValue() / 1000);
        }

    }

    static class Item {
        private String name;
        private int count;
        public Item(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }
}
