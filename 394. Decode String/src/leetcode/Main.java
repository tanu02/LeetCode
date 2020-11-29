package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		String st1 = "3[a]2[bc]"; 
		System.out.println(sol.decodeString(st1)); //aaabcbc
		String st2 = "abc3[cd]xyz";
		System.out.println(sol.decodeString(st2)); //abccdcdcdxyz
		String st3 = "3[a2[c]]";
		System.out.println(sol.decodeString(st3)); //accaccacc
		String st4 = "2[abc]3[cd]ef";
		System.out.println(sol.decodeString(st4)); //abcabccdcdcdef

	}

}