import java.util.EmptyStackException;

public class StackExample {
    public static void main(String[] args) {
        // Create a stack of integers
        Stack<Integer> myStack = new Stack<>();

        // Push elements onto the stack
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        // Display the stack
        System.out.println("Stack elements:");
        myStack.displayStack();

        // Pop an element from the stack
        try {
            int poppedElement = myStack.pop();
            System.out.println("Popped element: " + poppedElement);
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty. Cannot pop.");
        }

        // Peek at the top element of the stack
        try {
            int topElement = myStack.peek();
            System.out.println("Top element of the stack: " + topElement);
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty. Cannot peek.");
        }

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + myStack.isEmpty());
    }
}

class Stack<T> {
    private Node<T> top;

    // Inner class representing a node in the stack
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to push an element onto the stack
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    // Method to pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    // Method to peek at the top element of the stack
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Method to display the elements of the stack
    public void displayStack() {
        Node<T> current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(); // Move to the next line after printing the stack
    }
}
