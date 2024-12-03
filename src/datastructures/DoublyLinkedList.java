package datastructures;


public class DoublyLinkedList<T> {
	Node<T> head = null;
	Node<T> tail = null;
	
	private static class Node<T>{
		T value;
		Node<T> next;
		Node<T> prev;
		
		public Node(T value) {
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}
	
	public void display() {
		Node<T> p = this.head;
		while(p != null) {
			System.out.println(p.value);
			p = p.next;
		}
	}
	
	public void insertAtEnd(T value){
		if(this.head == null) {
			Node<T> newNode = new Node<T>(value);
			this.head = newNode;
			this.tail = newNode;
		}else {
			Node<T> newNode = new Node<T>(value);
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
		}
	}
	
	public void deleteAtEnd() {
		if(this.head == null) {
			System.out.println("the list is empty");
			return;
		}
		if(this.head == this.tail){
			this.head = null;
			this.tail = null;
			return;
		}
		this.tail = this.tail.prev;
		this.tail.next = null;
	}

	public void insertAtStart(T value){
		
		if(this.head == null) {
			Node<T> newNode = new Node<T>(value);
			this.head = newNode;
			this.tail = newNode;
		}else {
			Node<T> newNode = new Node<T>(value);
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}
	}
	
	public void deleteAtStart() {
		if(this.head == null) {
			System.out.println("the list is empty");
			return;
		}
		if(this.head == this.tail){
			this.head = null;
			this.tail = null;
			return;
		}
		this.head = this.head.next;
		this.head.prev = null;
	}

	public void deleteValue(T value) {
		if(this.head == null) {
			System.out.println("the value does not exist");
			return;
		}
		
		while(this.head != null && this.head.value == value) {
			this.head = this.head.next;
//			head.prev = null; nullpointexception can occur hear
			if(this.head == null) {
				this.tail = null;
				return;
			}
			head.prev = null;
		}
		
		if(this.tail == this.head && this.head.value == value ) {
			this.head = null;
			this.tail = null;
			return;
		}
		
		Node<T> iter = this.head;
		
		while(iter.next != null ) {
			if(iter.value == value) {
				iter.prev.next = iter.next;
				iter.next.prev = iter.prev;
			}
			iter = iter.next;
			if(iter.next == null && iter.value == value) {
				this.tail = iter.prev;
				tail.next = null;
				return;
			}
		}
	}
	
	public int length() {
	Node<T> p = this.head;
	int count = 0;
	while(p != null) {
		p = p.next;
		count++;
	}
	return count;
}
	
	
}

