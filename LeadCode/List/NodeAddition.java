package LeadCode.List;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NodeAddition {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1,
                        new ListNode(4,
                        new ListNode(6,
                        new ListNode(8,
                        new ListNode(4,
                        new ListNode(3,
                        new ListNode(8,
                        new ListNode(9,
                        new ListNode(3)))))))));

		ListNode l2 = new ListNode(4,
                        new ListNode(6,
                        new ListNode(8,
                        new ListNode(5,
                        new ListNode(3,
                        new ListNode(5,
                        new ListNode(8,
                        new ListNode(3,
                        new ListNode(2,
                        new ListNode(4,
                        new ListNode(5,
                        new ListNode(8,
                        new ListNode(9,
                        new ListNode(4,
                        new ListNode(6,
                        new ListNode(7,
                        new ListNode(3)))))))))))))))));

		System.out.println(addTwoNumbers(l1,l2));
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyListHead = new ListNode(0);
        ListNode currentNode = dummyListHead; 
        int carry = 0;
        while(l1 != null || l2 != null){
            int num1 = 0;
            int num2 = 0;
            if (l1 != null) num1 = l1.val;
            if (l2 != null) num2 = l2.val;
            int sum = carry + num1 + num2;
            carry = sum/10;

            currentNode.next = new ListNode(sum%10);
            currentNode = currentNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;


        }

        if(carry > 0){
            currentNode.next = new ListNode(carry);
        }

        return dummyListHead.next;
    }
}

