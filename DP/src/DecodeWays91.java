/*
91. Decode Ways
https://leetcode.com/problems/decode-ways/

*/

import java.util.Arrays;

class DecodeWays91 { //if 111 is taken then 1 11 and 11 1 are taken correct same as coin comb sum
    int[] dp;

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decode(s, 0);
    }

    private int decode(String s, int index) {
        if (index == s.length()) return 1;

        if (dp[index] != -1) return dp[index];
        int ans = 0;

        for (int i = index; i < s.length(); i++) {
            int len = Integer.parseInt(s.substring(index, i + 1));
            if (len > 0 && len <= 26) ans += decode(s, i + 1);
            else break;
        }
        dp[index] = ans;
        return dp[index];
    }
}
//every state considers all the substrings starting from index
//so  a word starts with  0 it  will automaticall discard that  whole state  because  no word starts with  0
//or if any work exceeds 26 then also that whole state is useless

class Main88 {
    public static void main(String[] args) {
        DecodeWays91 sol = new DecodeWays91();
        System.out.println(sol.numDecodings("12"));//2
        System.out.println(sol.numDecodings("226"));//3
        System.out.println(sol.numDecodings("0"));//0
        System.out.println(sol.numDecodings("06 "));//0
    }
}