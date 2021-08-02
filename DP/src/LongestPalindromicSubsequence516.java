//516.Longest Palindromic Subsequence
//        https://leetcode.com/problems/longest-palindromic-subsequence/

import java.util.Arrays;

class LongestPalindromicSubsequence516 {
    int[][] dp;

    public int longestPalindromeSubseq(String s) {
        if (s == null) return 0;

        dp = new int[s.length() + 1][s.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return lcs(s, new StringBuilder(s).reverse().toString(), s.length(), s.length());
    }

    private int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (dp[m][n] != -1) return dp[m][n];

        int ans;

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            ans = 1 + lcs(s1, s2, m - 1, n - 1);

        } else {
            ans = Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
        }
        dp[m][n] = ans;
        return dp[m][n];
    }
}

class Main2 {
    public static void main(String[] args) {
        LongestPalindromicSubsequence516 sol = new LongestPalindromicSubsequence516();
//        System.out.println(sol.longestPalindromeSubseq("bbbab")); //4
//        System.out.println(sol.longestPalindromeSubseq("cbbd")); //2
//        System.out.println(sol.longestPalindromeSubseq("abab")); //4
        System.out.println(sol.longestPalindromeSubseq("abacdfgdcaba"));
    }
}
