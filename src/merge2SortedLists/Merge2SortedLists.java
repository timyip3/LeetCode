package merge2SortedLists;

public class Merge2SortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] int_arr1 = {1,2,4};
		int[] int_arr2 = {1,3,4,5};
		ListNode l1 = createList(int_arr1);
		ListNode l2 = createList(int_arr2);
		
		//ListNode tmp = l1.next;
		ListNode result = mergeTwoLists(l1, l2);
		
		ListNode tmp = result;
		while (tmp != null) {
			System.out.println("value: " + tmp.val);
			tmp = tmp.next;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
        	return null;
		if (l2 == null) {
			return l1;
		}
		if (l1 == null) {
			return l2;
		}
		
		ListNode head = new ListNode(0);
		head.next = l1;
		
		ListNode l1_curr = head;
		ListNode l2_curr = l2;
		while (l2_curr != null) {
			while(l1_curr != null) {
				if (l2_curr == null)
					break;
				if (l1_curr.next == null) {
					ListNode tmp = new ListNode(l2_curr.val);
					l1_curr.next = tmp;
					
					l2_curr = l2_curr.next;
				} else if (l2_curr.val <= l1_curr.next.val) {
					ListNode tmp = new ListNode(l2_curr.val);
					tmp.next = l1_curr.next;
					l1_curr.next = tmp;
					
					l1_curr = l1_curr.next;
					l2_curr = l2_curr.next;
				} else {
					l1_curr = l1_curr.next;
				}
			}
		}
		
		return head.next;
    }
	
	public static ListNode createList(int[] s) {
		ListNode result = new ListNode(0);
		ListNode tmp = result;
		for (int i = 0; i<s.length;i++) {
			tmp.next = new ListNode(0);
			tmp.next.val = s[i];
			
			
			tmp = tmp.next;
		}
		
		return result.next;
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
