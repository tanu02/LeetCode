package leetcode;

public class Main {

    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] array = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int[] array1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 2;
        ArrayReader arrayReader = new ArrayReaderImpl();
        System.out.println(sol.search(arrayReader, target));
        System.out.println(sol.search(arrayReader, target));


    }


}
