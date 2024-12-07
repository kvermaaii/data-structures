package datastructures;


public class Queue<T> {
	Node <T> front;
	Node<T> rear;
	
	public static class Node<T>{
		T value;
		Node<T> next;
		
		public Node(T value) {
			this.value = value;
		}
	}
	
	public void enqueue(T value) {
		if(this.front == null) {
			Node<T> newNode = new Node<T>(value);
			this.front = newNode;
			this.rear = newNode;
			return;
		}
		Node<T> newNode = new Node<T>(value);
		this.rear.next = newNode;
		this.rear = newNode;
	}
	
	public void dequeue() {
		if(this.front == null) {
			System.out.println("The queue is empty");
			return;
		}
		this.front = this.front.next;
	}
	
	public void getFront() {
		if(this.front == null) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println(this.front.value);
	}
	
	public void getRear() {
		if(this.rear == null) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println(this.rear.value);
	}
	
	public boolean isEmpty() {
		return (this.front == null);
	}
	
	public void display() {
		Node<T> p = this.front;
		while(p != null) {
			System.out.println(p.value);
			p = p.next;
		}
	}
	
	
}
