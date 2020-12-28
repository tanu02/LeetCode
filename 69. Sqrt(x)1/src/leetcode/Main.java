package leetcode;

public class Main {

    public static void main(String[] args) {

        Solution sol = new Solution();
//		System.out.println(sol.mySqrt(4));
//		System.out.println(sol.mySqrt(8));
//		System.out.println(sol.mySqrt(2));
//		System.out.println(sol.mySqrt(1));
//		System.out.println(sol.mySqrt(0));
        int val = 2147395599;
        long valInLong1 = (long) val * (long) val; //explicitely convert each int into long
        System.out.println("Type cast both vals - no loss - " + valInLong1);//compiler will save val * val in an integer which is information loss
        long valInLong2 = (long) val * val; //first val is typecasted to val due to which second val is also typecasted automatically
        System.out.println("Type cast first val - no loss - " + valInLong2); // this is also overflow

        long valInLong3 = (long) (val * val);
        System.out.println("Type cast the product - loss - " + valInLong3); // compiler saves val*val in an int wich is info loss
        //System.out.println(sol.mySqrt(2147395599));
        System.out.println(sol.mySqrt(2147483647));
    }
}