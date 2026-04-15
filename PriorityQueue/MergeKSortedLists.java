package PriorityQueue;

import java.util.PriorityQueue;

public class MergeKSortedLists {
     // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode node: lists){
            if(node!=null)
                pq.offer(node);
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(pq.size()>0){
            ListNode t = pq.poll();
            if(t.next!=null)
                pq.offer(t.next);
            tail.next = t;
            tail = tail.next;
        }
        return head.next;
    }
}
}
