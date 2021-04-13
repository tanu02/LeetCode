import java.util.Stack;

//84. Largest Rectangle in Histogram

//https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {

        int[] leftSmallest = getLeftSmallest(heights);
        int[] rightSmallest = getRightSmallest(heights);
        int[] width = calculateWidth(leftSmallest, rightSmallest);
        return getMaxArea(heights, width);
    }

    private int[] getLeftSmallest(int[] arr) {
        Stack<Integer> stack = new Stack<>();
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
        Stack<Integer> stack = new Stack<>();
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

class Main2 {

    public static void main(String args[]) {
        LargestRectangleInHistogram sol = new LargestRectangleInHistogram();
     //  int[] heights = {2,1,5,6,2,3};
        int[] heights = {2,4};
        System.out.println(sol.largestRectangleArea(heights));
    }

    private static void printArr(int[] arr) {
        for (int val : arr) {
            System.out.print(val + "\t");
        }
    }
}