package problems.linkedList.easy;

import problems.linkedList.ListNode;


public class MergeTwoSortedLists21 {

    public static void main(String[] args) {
        MergeTwoSortedLists21 mergeTwoSortedLists = new MergeTwoSortedLists21();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        mergeTwoSortedLists.mergeTwoLists(l1, l2);
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode r = result;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                ListNode temp = new ListNode(l1.val);
                result.next = temp;
                l1 = l1.next;

            } else {
                ListNode temp = new ListNode(l2.val);
                result.next = temp;
                l2 = l2.next;
            }
            result = result.next;
        }

        if(l1 != null) {
            result.next = l1;
        }

        if(l2 != null) {
            result.next = l2;
        }

        return r.next;
    }
}
