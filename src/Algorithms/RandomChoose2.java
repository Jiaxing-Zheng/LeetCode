package Algorithms;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author skuang
 */
public class RandomChoose2 {
    private List<Item> items;
    private Node root;
    private Map<String, Node> map;
    private Random rand = new Random();

    public RandomChoose2(List<Item> items) {
        this.items = items;
//        root = buildTree(items);

    }



    static class Item {
        private String name;
        private int count;
        public Item(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }


    static class Node {
        private boolean isLeafNode;
        private int sum;
        private Node parent;
        private Node left;
        private Node right;

        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

}
