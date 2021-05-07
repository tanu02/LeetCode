import java.util.LinkedList;
import java.util.List;

public class MinStackMain {
}


//---------LeetCode--------
class MyStack<T> {
    List<T> list;

    MyStack() {
        list = new LinkedList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public void pop() {
        list.remove(getSize() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public T peek() {
        return list.get(getSize() - 1);
    }

}

class MinStack {

    MyStack<Integer> stack;
    MyStack<Integer> minStack;

    public MinStack() {
        stack = new MyStack<>();
        minStack = new MyStack<>();
    }

    public void push(int item) {
        stack.push(item);
        if (minStack.isEmpty() || item <= minStack.peek()) {
            minStack.push(item);
        }
    }

    public void pop() {

        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

//Generic Stack
class MyStackG<T extends Comparable> {
    List<T> list;

    MyStackG() {
        list = new LinkedList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public void pop() {
        list.remove(getSize() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public T peek() {
        return list.get(getSize() - 1);
    }

}
//Generic Stack
class MinStackG<E extends Comparable> {

    MyStackG<E> stack;
    MyStackG<E> minStack;

    public MinStackG() {
        stack = new MyStackG<>();
        minStack = new MyStackG<>();
    }

    public void push(E item) {
        stack.push(item);
        if (minStack.isEmpty() || item.compareTo(minStack.peek()) <= 0) {
            minStack.push(item);
        }
    }

    public void pop() {

        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public E top() {
        return stack.peek();
    }

    public E getMin() {
        return minStack.peek();
    }
}

