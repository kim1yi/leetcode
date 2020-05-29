import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//包可见
class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        for(ListNode node : lists) {
            pq.add(node);
        }

        ListNode head = pq.poll();
        ListNode next = head.next;
        if (next!=null)
            pq.add(next);
        while (!pq.isEmpty()) {
            next = pq.poll();
            if (next.next != null) {
                pq.add(next.next);
                next = next.next;
            }
        }

        return head;
    }
}

