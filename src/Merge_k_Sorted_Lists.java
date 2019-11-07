/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
    	if (lists == null || lists.length == 0) {
    		return null;
    	}

    	int k = lists.length;
    	ListNode temp = new ListNode(0);
    	ListNode head = temp;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(k, new Comparator<ListNode>(){
        	public int compare(ListNode l1, ListNode l2) {
        		return l1.val >= l2.val ? 1 : -1;
        	}
        });

        for (int i = 0; i < k; i++) {
        	if (lists[i] != null) {
        		heap.add(lists[i]);
        	}
        }

        while (heap.size() != 0) {
        	ListNode cur = heap.poll();
        	temp.next = cur;
        	temp = temp.next;

        	if (cur.next != null) {
        		heap.add(cur.next);
        	}
        }

        return head.next;

    }
}