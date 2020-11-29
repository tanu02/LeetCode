package leetcode;

public class Biz {

	public void reverseString(char[] s) {

		int st = 0;
		int end = s.length - 1;
		char temp;

		while(st < end) {

			temp = s[st];
			s[st++] = s[end];
			s[end--] = temp;
		}
	}
}
