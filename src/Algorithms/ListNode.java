package Algorithms;

/**
 * Defenition of a singly linked list with numerator to string method
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }
    @Override
    public String toString() {
        ListNode head = this;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val + " ");
            head = head.next;
        }
        return sb.toString();
    }
}

