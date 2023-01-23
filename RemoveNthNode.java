public class RemoveNthNode {

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 1;
        removeNthFromEnd(listNode, 1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int k = 0;
        ListNode nthPointer = head;
        while (k <= n) {
            if(nthPointer.next != null) {
               nthPointer = nthPointer.next;
            } else {
                head = head.next;
                return head;
            }
            k++;
        }
        ListNode firstPointer = head;
        while (firstPointer.next != null && nthPointer.next != null) {
            nthPointer = nthPointer.next;
            firstPointer = firstPointer.next;
        }
        if (firstPointer.next != null) {
            firstPointer.next = firstPointer.next.next;
        }
        return head;
    }

}

class ListNode {
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
