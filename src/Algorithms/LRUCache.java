package Algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache( 2 * capacity * );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */
class LRUCache {
    DoublyLinkedNode head;
    DoublyLinkedNode tail;
    Map<Integer, DoublyLinkedNode> map;
    int size;
    public LRUCache(int capacity) {
        head = new DoublyLinkedNode(0, 0);
        tail = new DoublyLinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        size = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoublyLinkedNode node = map.get(key);
            delete(node);
            add(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoublyLinkedNode curr = map.get(key);
            delete(curr);
            curr.val = value;
            add(curr);
        } else {
            DoublyLinkedNode newNode = new DoublyLinkedNode(key, value);
            add(newNode);
        }
    }

    private static class DoublyLinkedNode {
        DoublyLinkedNode prev;
        DoublyLinkedNode next;
        int key;
        int val;
        public DoublyLinkedNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    /**
     * delete node in linkedlist and map
     * @param node
     */
    private void delete(DoublyLinkedNode node) {
        DoublyLinkedNode prev = node.prev;
        DoublyLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(node.key);
    }

    /**
     * add value in queue and hashmap, and delete the last value in queue and hashmap if neccessary
     * @param newNode
     */
    private void add(DoublyLinkedNode newNode) {
        insertQueue(newNode);
        map.put(newNode.key, newNode);
        if (map.size() > size) {
            DoublyLinkedNode toBeDelete = tail.prev;
            delete(toBeDelete);
            map.remove(toBeDelete.key);
        }
    }

    private void insertQueue(DoublyLinkedNode node) {
        DoublyLinkedNode oldFirst = head.next;
        head.next = node;
        oldFirst.prev = node;
        node.prev = head;
        node.next = oldFirst;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 1);

        cache.put(2, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println(cache.get(2));       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */