package codingPractice;

public class SinglyLinkedList<E> {

	private Node<E> head;
	private Node<E> tail;
	private int count = 0;
	
	private static class Node<E>{
		private E value;
		private Node<E> next;
		
		public Node(E v, Node<E> n) {
			value = v;
			next = n;
		}
		
		//GETTERS AND SETTERS (NODE)
		public E getValue() {
			return value;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
	}
	
	//GETTERS AND SETTERS
	public E getFirst() {
		if (this.isEmpty()) return null;
		return head.getValue();
	}
	
	public E getLast() {
		if (this.isEmpty()) return null;
		return tail.getValue();
	}
	
	public int getCount() {
		return count;
	}
	
	//METHODS
	public boolean isEmpty() {
		return count == 0;
	}

	public void addFirst(E v) {
		head = new Node<>(v, head);
		if(this.isEmpty()) {
			tail = head;
		}
		count++;
	}
	
	public void addLast(E v) {
		Node<E> n = new Node<>(v, null);
		if(this.isEmpty()) {
			head = n;
		}
		else {
			tail.setNext(n);
		}
		tail = n;
		count++;
	}
	
	public E removeFirst() {
		if(isEmpty()) return null;
		E returnVal = head.getValue();
		head = head.getNext();
		count--;
		if(isEmpty()) {
			tail = null;
		}
		return returnVal;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
