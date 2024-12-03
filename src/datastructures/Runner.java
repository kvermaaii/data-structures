package datastructures;

public class Runner {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(1);
		list.insert(2);
		list.insert(1);
		list.insert(2);
		list.insert(1);
		System.out.println("The list is: ");
		list.display();
		list.deleteValue(1);
		System.out.println("The list after deleting 1 is: ");
		list.display();
		
		DoublyLinkedList<String> list2 = new DoublyLinkedList<String>();
		list2.insertAtEnd("This");
		list2.insertAtEnd("is");
		list2.insertAtEnd("a");
		list2.insertAtEnd("doubly");
		list2.insertAtEnd("linked");
		list2.insertAtEnd("list");
		list2.display();
		list2.deleteValue("linked");
		System.out.println("List after deleting linked: ");
		list2.display();

	}

}
