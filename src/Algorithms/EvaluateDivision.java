package Algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author skuang
 */
public class EvaluateDivision {
    public static double evaluate1(String[] from, String[] to, double[] val, String qfrom, String qto) {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, List<Double>> values = new HashMap<>();
        int n = from.length;
        for (int i = 0; i < n; i++) {
            String f = from[i];
            String t = to[i];
            double v = val[i];
            if (!map.containsKey(f)) map.put(f, new ArrayList<>());
            if (!map.containsKey(t)) map.put(t, new ArrayList<>());
            if (!values.containsKey(f)) values.put(f, new ArrayList<>());
            if (!values.containsKey(t)) values.put(t, new ArrayList<>());
            map.get(f).add(t);
            values.get(f).add(v);
            map.get(t).add(f);
            values.get(t).add(1.0 / v);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> sq = new ArrayDeque<>();
        Queue<Double> vq = new ArrayDeque<>();
        sq.offer(qfrom);
        vq.offer(1.0);
        visited.add(qfrom);
        while (!sq.isEmpty()) {
            String currString = sq.poll();
            Double currVal = vq.poll();
            if (currString.equals(qto)) {
                return currVal;
            }
            List<String> neighbors = map.getOrDefault(currString, new ArrayList<>());
            List<Double> neightborsval = values.getOrDefault(currString, new ArrayList<>());
            for (int i = 0; i < neighbors.size(); i++) {
                if (visited.contains(neighbors.get(i))) continue;
                sq.offer(neighbors.get(i));
                vq.offer(currVal * neightborsval.get(i));
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        String[] from = {"rmb", "usd"};
        String[] to   = {"usd", "krd"};
        double[] val  = {0.13, 7};
        System.out.println(evaluate1(from, to, val, "rmb", "krd"));
    }
}
