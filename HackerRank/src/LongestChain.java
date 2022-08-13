import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LongestChain {
    static Set<String> set;

    public static void main(String[] args) {
        String[] arr = {"a", "b", "ba", "bca", "bda", "bdca"};
        List<String> list = Arrays.asList(arr);
        System.out.println(longestChain(list));
    }


    public static int longestChain(List<String> words) {
        set = new HashSet<>();
        for (String w : words) {
            set.add(w);
        }
        int maxLen = 0;
        // Write your code here
        for (String w : words) {
            maxLen = Math.max(maxLen, checkDic(w));
        }
        return maxLen;
    }

    private static int checkDic(String w) {
        int len = 0;
        String st1 = "";
        for (int i = 0; i < w.length(); i++) {
            st1 = w.substring(0, i) + w.substring(i + 1, w.length());
            if (set.contains(st1)) {
                len = Math.max(len, st1.length());
            }
        }
        return len;
    }
}

