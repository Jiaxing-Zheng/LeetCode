package Algorithms;

import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 Example:

 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6

 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2)-> Integer.compare(o1.val, o2.val));
        for (ListNode l : lists) {
            if (l != null) pq.add(l);
        }
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            head.next = curr;
            head = head.next;
            if (curr.next != null) pq.add(curr.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists sol = new MergeKSortedLists();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        System.out.println(sol.mergeKLists(lists));
    }
}
