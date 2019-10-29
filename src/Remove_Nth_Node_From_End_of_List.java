/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

public class Remove_Nth_Node_From_End_of_List {
	public ListNode removeNodeFromEnd(int n, ListNode head) {
		  if (head == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode dummy_2 = dummy;
        ListNode dummy_3 = dummy;


		int count = 0, remain = 0;

		while (dummy.next != null) {
			count++;
			dummy = dummy.next;
		}

		remain = count - n;

		while (remain != 0) {
			dummy_2 = dummy_2.next;
			remain --;
		}

		ListNode removedNode = dummy_2.next;

		if (removedNode != null) {
			dummy_2.next = removedNode.next;
		} else {
			dummy_2.next = null;
		}

		return dummy_3.next;
	}
}