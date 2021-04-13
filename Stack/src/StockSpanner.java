//Stock span
//
//        901. Online Stock Span
//
//        https://leetcode.com/problems/online-stock-span/

import java.util.Stack;

class StockSpanner {

    Stack<Integer[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int index = 0;
        int ans;

        if (!stack.isEmpty()) index = stack.peek()[1] + 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }

        if (stack.isEmpty()) ans = index + 1;//if first element or popped everything | size will be index + 1
        else ans = index - stack.peek()[1]; //nearest > element's index- chop off that much length

        stack.push(new Integer[]{price, index});
        return ans;

    }
}

class Main1 {

    public static void main(String args[]) {
        StockSpanner obj = new StockSpanner();
        // int[] arr = {100, 80, 60, 70, 60}; //continuous small array
        int[] arr = {31, 41, 48, 59, 79};

        for (int val : arr) {
            System.out.println(obj.next(val));
        }
    }

    private static void printArr(int[] arr) {
        for (int val : arr) {
            System.out.print(val + "\t");
        }
    }
}

//test  cases
//1) empty stack
//2) 2 element -- 1, 2
//3) 2 element -- 2, 1
//4) 4, 3, 2, 5


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */