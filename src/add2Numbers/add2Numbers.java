package add2Numbers;

public class add2Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(0);
		int[] num2 = {3, 1, 2};
		ListNode l2 = initNum(num2);
		
		ListNode cur = l2;
		
		while(cur != null) {
			System.out.println("l2: " + cur.val);
			cur = cur.next;
		}
	}
	
	public static ListNode initNum(int[] num) {
		int i =0;
		ListNode list = new ListNode(0);
		
		while (i < num.length) {
			addNode(num[i], list);
			i++;
		}
		
		return list;
	}
	
	public static void addNode(int num, ListNode n) {
		ListNode cur = n;
		while (cur != null) {
			cur = cur.next;
		}
		
		n = new ListNode(num);
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = l1;
        ListNode itL2 = l2;
        ListNode itResult = resultNode;
        
        while (itL2 != null) {
            if (itResult == null)
                itResult = new ListNode(0);
            
            itResult.val = itResult.val + itL2.val;
            System.out.println("result.val: " + itResult.val);
            
            if (itResult.val >= 10) {
                if (itResult.next == null)
                    itResult.next = new ListNode(0);
                
                itResult.val = itResult.val %10;
                
                itResult.next.val++;
            }
            
            itL2 = itL2.next;
            itResult = itResult.next;
            System.out.println("result: " + itResult == null);
        }
        
        
        return resultNode;
    }

}
