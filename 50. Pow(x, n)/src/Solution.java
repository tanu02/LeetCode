class Solution {
    public double myPow(double x, int n) {
        long n1 = n;
        if (n1 < 0) {
            n1 = -n1;
            x = 1 / x;
        }

        return exp(x, n1);
    }

    private double exp(double a, long b) {
        if (b == 0) return 1;
        double temp = exp(a, b / 2);
        temp *= temp;
        if (b % 2 == 1) temp *= a;  //4 * 4 * 2
        return temp;
    }
}