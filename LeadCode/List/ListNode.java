package LeadCode.List;

public class ListNode {
    int value;
    ListNode next;

    ListNode(){}

    ListNode(int value){
        this.value = value;
    }

    ListNode(int value, ListNode next){
        this.value = value;
        this.next = next;
    }

    public void add(int num){
        ListNode temp = new ListNode(num);
        ListNode current = this;
        while(current.next != null){
            current = current.next;
        }
        current.next = temp;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode current = this;
        result.append('[');
        while (current != null) {
            result.append(current.value);
            if (current.next != null) {
                result.append(",");
            }
            current = current.next;
        }
        result.append(']');
        return result.toString();
    }
}
