package reverseKGrp;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return head;

        if(!isDoReverse(head, k))
            return head;

        ListNode tail_old = reverseKGroup(findLastNode(head, k).next, k);
        ListNode head_k = reverse(head, 1, k);
        ListNode tail_k = findLastNode(head_k, k);
        if (tail_k != null)
            tail_k.next = tail_old;
        return head_k;
    }

    private ListNode findLastNode(ListNode head, int k) {
        ListNode cur = head;
        int length = 1;
        while (cur != null && length < k) {
            length++;
            cur = cur.next;
        }

        return cur;
    }

    private boolean isDoReverse(ListNode head, int k) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        if (k > length)
            return false;

        return true;
    }

    public ListNode reverse(ListNode head, int index, int k) {
        if (head == null || head.next == null || index == k)
            return head;

        ListNode tail = reverse(head.next,index+1, k);
        head.next.next = head;
        head.next = null;

        return tail;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        //input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) {
        String line = "1,2,3,4,5";
        ListNode head = stringToListNode(line);
        int n = 4;

        ListNode ret = new Solution().reverseKGroup(head, n);

        String out = listNodeToString(ret);

        System.out.print(out);
    }
}
