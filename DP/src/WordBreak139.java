import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
139.Word Break

        https://leetcode.com/problems/word-break/
*/
class WordBreak139 {
    Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;

        dp = new Boolean[s.length()];

        Set<String> set = new HashSet<>(wordDict);
        return dp(s, 0, set);

    }

    private boolean dp(String s, int index, Set<String> set) {

        if (index == s.length()) return true;
        if (dp[index] != null) return dp[index];

        boolean result = false;

        for (int i = index; i < s.length(); i++) {
            if (set.contains(s.substring(index, i + 1))) {
                if (dp(s, i + 1, set)) {
                    result = true;
                    break;
                }
            }
        }

        dp[index] = result;
        return dp[index];
    }
}

class Main44 {
    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordDict = {"leet", "code"};
        WordBreak139 sol = new WordBreak139();
        System.out.println(sol.wordBreak(s, Arrays.asList(wordDict)));//true

        String s1 = "applepenapple";
        String[] wordDict1 = {"apple","pen"};
        System.out.println(sol.wordBreak(s1, Arrays.asList(wordDict1)));//true

        String s2 = "catsandog";
        String[] wordDict2 = {"cats","dog","sand","and","cat"};
        System.out.println(sol.wordBreak(s2, Arrays.asList(wordDict2)));//false
    }
}