import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//包可见
class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(final int val) { this.val = val; }
        ListNode(final int val, final ListNode next) { this.val = val; this.next = next; }
}

public class Solution23 {
    public ListNode mergeKLists(final ListNode[] lists) {
        
        int size = lists.length;
        if (size == 0 || lists[0] == null)
            return null;

        //Comparator的写法，利用lambdma
        Comparator<ListNode> comparator = (o1, o2)->{return o1.val - o2.val;};
        final PriorityQueue<ListNode> pq = new PriorityQueue<>(size, comparator);

        //另一种写法，覆盖compare方法
        // PriorityQueue<ListNode> pq = new PriorityQueue<>(size, new Comparator<ListNode>() {
        //     @Override
        //     public int compare(ListNode o1, ListNode o2) {
        //         if (o1.val < o2.val)
        //             return -1;
        //         else if (o1.val == o2.val)
        //             return 0;
        //         else
        //             return 1;
        //     }
        // });

        for(final ListNode node : lists) {
            //这个判断很重要，null对象也会改变lists的length大小
            if (node != null)
                pq.add(node);
        }

        //总是会遇到这样一个问题，直接在原链表上进行修改的时候总是不知道该怎么处理入口
        //下次一定要记住用一个新的空头来作为入口！！！
        final ListNode head = new ListNode();
        ListNode tail = head;

        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;

            if (tail.next != null) {
                pq.add(tail.next);
            }
        }

        return head;
    }
}

