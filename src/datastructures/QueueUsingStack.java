package datastructures;

public class QueueUsingStack<T> {
    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    public void enqueue(T value) {
        stack1.push(value);
    }

    public T dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop().value);
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.pop().value;
        } else {
            System.out.println("Queue is empty");
            return null;
        }
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public T front() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop().value);
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.getTop().value;
        }
        System.out.println("Queue is empty");
        return null;
    }
}
