

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        double x = 2.00000; int n = 10;
        double x1 = 2.10000; int n1 = 3;
        double x2= 2.00000; int n2 = -2;
        double x3 = 2.00000; int n3 = -2147483648;
        System.out.println(sol.myPow(x, n));
        System.out.println(sol.myPow(x1, n1));
        System.out.println(sol.myPow(x2, n2));
        System.out.println(sol.myPow(x3, n3));
    }

}
