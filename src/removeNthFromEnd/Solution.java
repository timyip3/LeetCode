package removeNthFromEnd;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0)
            return head;

        int length = 0;
        ListNode it = head;
        while (it != null) {
            length++;
            it = it.next;
        }

        if (n > length)
            return head;
        if (n == length) {
            head = head.next;
            return head;
        }

        int index = length - n + 1;
        it = head;
        int i = 1;
        while (i < index - 1) {
            it = it.next;
            i++;
        }

        ListNode del_n = it.next;
        it.next = null;
        if (del_n.next != null) {
            it.next = del_n.next;
        }

        return head;
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
        String line = "1,2,3,4";
        ListNode head = stringToListNode(line);
        int n = 1;

        ListNode ret = new Solution().removeNthFromEnd(head, n);

        String out = listNodeToString(ret);

        System.out.print(out);
    }
}

