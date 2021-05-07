package leetcode;

import java.util.LinkedList;
import java.util.List;


class MyStack<T extends Comparable> {
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

class Main {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        // System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
        System.out.println(minStack.top()); //0

    }
}
//reference https://codereview.stackexchange.com/questions/55386/stack-with-getminimum-operation
