package Algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author skuang
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : wordList) map.put(s, 0);
        bfs(beginWord, endWord, map);
        if (!map.containsKey(endWord)) return result;
        List<String> curr = new ArrayList<>();
        curr.add(beginWord);
        dfs(beginWord, endWord, map, curr, result);
        return result;
    }

    private void bfs(String beginWord, String endWord, Map<String, Integer> map) {
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int n = 0; n < size; n++) {
                char[] curr = queue.poll().toCharArray();
                for (int i = 0; i < curr.length; i++) {
                    char c = curr[i];
                    for (int j = 0; j < 26; j++) {
                        if (j == c - 'a') continue;
                        curr[i] = (char) (j + 'a');
                        String currStr = new String(curr);
                        Integer strCount = map.get(currStr);
                        if (strCount != null && strCount == 0) {
                            map.put(currStr, count);
                            queue.offer(currStr);
                        }
                        if (currStr.equals(endWord)) return;
                    }
                    curr[i] = c;
                }
            }
            count++;
        }
    }

    private void dfs(String beginWord, String endWord, Map<String, Integer> map, List<String> res, List<List<String>> result) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(res));
            return;
        }
        char[] curr = beginWord.toCharArray();
        for (int i = 0; i < curr.length; i++) {
            char c = curr[i];
            for (int j = 0; j < 26; j++) {
                if (j == c - 'a') continue;
                curr[i] = (char) (j + 'a');
                String currStr = new String(curr);
                Integer strCount = map.get(currStr);
                if (strCount == null) continue;
                if (strCount < res.size()) continue;
                res.add(currStr);
                dfs(currStr, endWord, map, res, result);
                res.remove(res.size() - 1);
            }
            curr[i] = c;
        }

    }

    public static void main(String[] args) {
        WordLadderII sol = new WordLadderII();
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(sol.findLadders("hit", "cog", list));
    }
}
