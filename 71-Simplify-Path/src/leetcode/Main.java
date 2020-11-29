package leetcode;


public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		String st1 = "/home/";
		String st2 = "/../";
		String st3 =  "/home//foo/";
		String st4 = "/a/../../b/../c//.//";
		String st5 = "/a//b////c/d//././/..";
		
		System.out.println(sol.simplifyPath(st1));
		System.out.println(sol.simplifyPath(st2));
		System.out.println(sol.simplifyPath(st3));
		System.out.println(sol.simplifyPath(st4));
		System.out.println(sol.simplifyPath(st5));
			
	}

}
