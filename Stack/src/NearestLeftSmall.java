import java.util.Stack;

public class NearestLeftSmall {

    public int[] getSmallest(int[] arr) {

        if (arr == null || arr.length == 0) return new int[0];

        Stack<Integer> stack = new Stack<>();
        int ans;
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) ans = -1;
            else ans = stack.peek(); //nearest smallest element, popped all the > elements

            output[i] = ans;
            stack.push(i);
        }
        return output;

    }

}

class Main {

    public static void main(String args[]) {
        NearestLeftSmall smallest = new NearestLeftSmall();
        int[] arr = {1, 6, 4, 10, 2, 5}; // [-1, 0, 0, 2, 0, 4]
        int[] arr1 = {1, 3, 0, 2, 5}; // [-1, 0, -1, 2, 3]
        printArr(smallest.getSmallest(arr1));

    }

    private static void printArr(int[] arr) {
        for (int val : arr) {
            System.out.print(val + "\t");
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