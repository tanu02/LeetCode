public class Stack {
}

class StockSpanner {

    java.util.Stack<Integer[]> stack;

    public StockSpanner() {
        stack = new java.util.Stack<>();
    }

    public int next(int price) {
        int index = 0;
        int ans;

        if (!stack.isEmpty()) index = stack.peek()[1] + 1; //1st is index 0 is the price

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }

        if (stack.isEmpty()) ans = index + 1;//if first element or popped everything | size will be index + 1
        else ans = index - stack.peek()[1]; //nearest > element's index- chop off that much length

        stack.push(new Integer[]{price, index});
        return ans;

    }


    public class NearestLeftSmall {

        public int[] getSmallest(int[] arr) {

            if (arr == null || arr.length == 0) return new int[0];

            java.util.Stack<Integer> stack = new java.util.Stack<>();
            int ans;
            int[] output = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) ans = -1;
                else ans = stack.peek(); //nearest smallest element, popped all the > elements

                stack.push(i);
                output[i] = ans;
            }
            return output;

        }

    }
}


//                 |
//                 |
//          |      |
//          |   |  |
//       |  | _ |  |

//      [1, 3, 0, 2, 5]
//       0  1  2  3  4

//   compare with i  and pop every > element creating a choking point of current element

//smallest in left so loop starts from left

class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {

        int[] leftSmallest = getLeftSmallest(heights);
        int[] rightSmallest = getRightSmallest(heights);
        int[] width = calculateWidth(leftSmallest, rightSmallest);
        return getMaxArea(heights, width);
    }

    private int[] getLeftSmallest(int[] arr) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int ans;
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) ans = -1;
            else ans = stack.peek();

            stack.push(i);
            output[i] = ans;
        }
        return output;
    }

    private int[] getRightSmallest(int[] arr) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int ans;
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) ans = arr.length;
            else ans = stack.peek();

            stack.push(i);
            output[i] = ans;
        }
        return output;
    }

    private int[] calculateWidth(int[] leftSmallest, int[] rightSmallest) {
        int[] width = new int[leftSmallest.length];

        for (int i = 0; i < leftSmallest.length; i++) {
            width[i] = rightSmallest[i] - leftSmallest[i] - 1;
        }

        return width;
    }


    private int getMaxArea(int[] heights, int[] width) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, width[i] * heights[i]);
        }
        return maxArea;
    }

}

