package Interviews.DataStructure.LinkedList;

public class SingliLinkedList <T> {
	Node<T> head;
	public SingliLinkedList(){
		head = new Node(null);
	}

	public void add(T data){

		Node<T> newNode = new Node(data);
		if(head == null){
			head = newNode;
		}
		else{
			Node<T> temp = head;

			while(temp.next != null){
				temp = temp.next;
			}

			temp.next = newNode;
		}
	}

	public boolean remove(T data){
		if(! contains(data)) return false;

		if(head.data.equals(data)){
			head = head.next;
			return true;
		}

		Node<T> temp = head;
		while(temp.next != null){
			if(temp.next.data.equals(data)){
				temp.next = temp.next.next;
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public boolean contains(T data){
		Node<T> temp = head;
		while(temp != null){
			if(temp.data.equals(data)){
				return true;
			}
			else{
				temp = temp.next;
			}
		}
		return false;
	}
}
