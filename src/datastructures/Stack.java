package datastructures;

public class Stack<T> {
    Node<T> top;

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (this.top == null) {
            this.top = newNode;
        } else {
            newNode.next = this.top;
            this.top = newNode;
        }
    }

    public void pop() {
        if (this.top == null) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Popped element: " + this.top.value);
        this.top = this.top.next;
    }

    public boolean isEmpty() {
        return (this.top == null);
    }

    public void getTop() {
        if (this.top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top element: " + this.top.value);
        }
    }

    public static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
