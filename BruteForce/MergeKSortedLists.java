import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            List<Integer> tempList = new ArrayList<>();
            for (ListNode node : lists) {
                while (node != null) {
                    tempList.add(node.val);
                    node = node.next;
                }
            }
            Collections.sort(tempList);
            ListNode head = new ListNode(0);
            ListNode tail = head;
            for (int val : tempList) {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
            return head.next;
        }
    }
}
