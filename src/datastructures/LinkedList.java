package datastructures;

class LinkedList {
	
	Node head = null;
	Node tail = null;
	
	/*
	making the Node class as static inner class allow us to declare class with the
	same name within the package plus the Inner classes (whether static or non-static) are part of the outer class's scope. 
	 */

	private static class Node{
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	public void display() {
		Node p = this.head;
		while(p != null) {
			System.out.println(p.value);
			p = p.next;
		}
	}
	
	public void insert(int value) {
		if (this.head == null) {
			Node newNode = new Node(value);
			this.head = newNode;
			this.tail = newNode;
	    } else {
			Node newNode = new Node(value);
			this.tail.next = newNode;
			this.tail = newNode;
		}
	}
	
	public void deleteLast() {
		// Case 1: Empty List
	    if (this.head == null) {
	        System.out.println("List is empty. Nothing to delete.");
	        return;
	    }

	    // Case 2: Single element
	    if (this.head == this.tail) {
	        this.head = null;
	        this.tail = null;
	        return;
	    }
	    
	    // Case 3
		Node iter = this.head;
		while(iter.next != this.tail) {
			iter = iter.next;
		}
		this.tail = iter;
		this.tail.next = null;
		
	}
	
	public int length() {
		Node p = this.head;
		int count = 0;
		while(p != null) {
			p = p.next;
			count++;
		}
		return count;
	}
	
	public void deleteValue(int value) {
		Node iter = this.head;
		
		if(this.length() == 0) {
			System.out.println("the list is empty");
			return;
		}
		
		if(this.length() == 1 && iter.value == value) {
			this.head = null;
			return;
		}
		// if head contains the value
		while(this.head.value == value) {
			this.head = this.head.next;
		}
		
		// traversing the list for the target value
		while (iter.next != null) {
			iter = iter.next;
			
			if(iter.next != null && iter.next.value == value ) {
				if(iter.next == this.tail) {
					iter.next = null; 
					this.tail = iter;
				}else {
					iter.next = iter.next.next;

				}
			}
		}
	}

}



