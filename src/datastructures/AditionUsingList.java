package datastructures;

import datastructures.DoublyLinkedList.Node;

public class AditionUsingList {
	DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
	DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();
	DoublyLinkedList<Integer> sum = new DoublyLinkedList<>();

	public void add(int a, int b) {
		while(a != 0) {
			list1.insertAtEnd( a % 10);
			a = a -  (a % 10);
			a = a/10;
		}
		while(b != 0) {
			list2.insertAtEnd( b % 10);
			b = b -  ( b % 10);
			b = b/10;
		}
		DoublyLinkedList<Integer>.Node<Integer> list1Pointer = list1.head;
		DoublyLinkedList<Integer>.Node<Integer>  list2Pointer = list2.head;
		int remainder = 0;
		while(list1Pointer != null && list2Pointer != null) {
			int sm = list1Pointer.value+list2Pointer.value + remainder;
			if(sm < 10) {
				remainder = 0;
				sum.insertAtStart(sm);
			}else {
				remainder = 1;
				sm = sm%10;
				sum.insertAtStart(sm);
			}
			list1Pointer = list1Pointer.next;
			list2Pointer = list2Pointer.next;
		}
		if(list1.length() == list2.length()) {
			if(remainder == 1) {
				sum.insertAtStart(1);
			}
			sum.display();
			return;
		}
		if(list1.length() > list2.length()) {
			while(list1Pointer != null ) {
					int sm = list1Pointer.value + remainder;
					remainder = (sm - sm%10)/10;
					sm = sm%10;
					sum.insertAtStart(sm);
					list1Pointer = list1Pointer.next;
			}
		} else{
			while(list2Pointer != null) {
					int sm = list2Pointer.value + remainder;
					remainder = (sm - sm%10)/10;
					sm = sm%10;
					sum.insertAtStart(sm);
					list2Pointer = list2Pointer.next;
			}
		}
		sum.display();
		return;
	}
}
