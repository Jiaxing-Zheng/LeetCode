package Algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author skuang
 */
class AutocompleteSystem {

    private TrieTree trie;
    private StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new TrieTree();
        for (int i = 0; i < sentences.length; i++) {
            trie.insert(sentences[i], times[i]);
        }
        sb = new StringBuilder();
    }

    public List<String> input(char c) {
        List<String> result = new LinkedList<>();
        if (c == '#') {
            trie.insert(sb.toString(), 1);
            sb = new StringBuilder();
            return result;
        }
        sb.append(c);
        Node root = trie.search(sb.toString());
        PriorityQueue<Node> pq = new PriorityQueue<>(10, (a, b) ->
            a.count == b.count ? compareStrings(b.s, a.s) : Integer.compare(a.count, b.count));
        dfs(root, pq);
        while (!pq.isEmpty()) result.add(0, pq.poll().s);
        return result;
    }

    private static void dfs(Node root, PriorityQueue<Node> pq) {
        if (root == null) return;
        if (root.count != 0)
            pq.offer(root);
        if (pq.size() > 3) pq.poll();
        for (Node n : root.map.values()) {

            dfs(n, pq);
        }
    }

    private static class TrieTree {
        private Node root = new Node(0, ' ', "");

        public void insert(String s, int count) {
            Node curr = root;
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(c);
                Node next = curr.map.get(c);
                if (next == null) {
                    Node n = new Node(0, c, sb.toString());
                    curr.map.put(c, n);
                    next = n;
                }
                curr = next;
            }
            curr.count += count;
        }

        public Node search(String prefix) {
            if (prefix == null || prefix.length() == 0) return root;
            Node curr = root;
            for (char c : prefix.toCharArray()) {
                Node next = curr.map.get(c);
                if (next == null) return null;
                curr = next;
            }
            return curr;
        }
    }

    private static class Node {
        private int count;
        private char c;
        private String s;
        private Map<Character, Node> map = new HashMap<>();

        public Node(int count, char c, String s) {
            this.count = count;
            this.c = c;
            this.s = s;
        }
    }
    public static int compareStrings(String s1, String s2) {
        int comparison = 0;
        int c1, c2;
        for(int i = 0; i < s1.length() && i < s2.length(); i++) {
            c1 = (int) s1.toLowerCase().charAt(i);   // See note 1
            c2 = (int) s2.toLowerCase().charAt(i);   // See note 1
            comparison = c1 - c2;   // See note 2

            if(comparison != 0)     // See note 3
                return comparison;
        }
        if(s1.length() > s2.length())    // See note 4
            return 1;
        else if (s1.length() < s2.length())
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        String[] sentences = new String[] {
                "i love you",
                "island",
                "ironman",
                "i love leetcode"
        };
        int[] counts = new int[] {5,3,2,2};
        AutocompleteSystem sol = new AutocompleteSystem(sentences, counts);
        System.out.println(sol.input('i'));
        System.out.println(sol.input(' '));
        System.out.println(sol.input('a'));
        System.out.println(sol.input('#'));
        System.out.println(sol.input('i'));
        System.out.println(sol.input(' '));
        System.out.println(sol.input('a'));
        System.out.println((int) ' ');
        System.out.println((int) 'a');
    }
}