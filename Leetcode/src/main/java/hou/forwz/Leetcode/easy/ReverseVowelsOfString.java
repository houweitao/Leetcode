package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月20日上午12:34:24
 */

public class ReverseVowelsOfString {
	public static void main(String[] args) {
		ReverseVowelsOfString rw = new ReverseVowelsOfString();
		System.out.println(rw.reverseVowels("hello"));
	}

	public String reverseVowels(String s) {
		if (s.length() < 1)
			return s;

		int left = 0, right = s.length() - 1;
		char[] word = s.toCharArray();
		while (left < right) {

			while (!is(word[left]) && left < right)
				left++;

			while (!is(word[right]) && right > left)
				right--;

			swap(word, left, right);
			left++;
			right--;
		}

		return new String(word);
	}

	private void swap(char[] word, int left, int right) {
		char c = word[left];
		word[left] = word[right];
		word[right] = c;
	}

	private boolean is(char c) {
		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o'
				|| c == 'u')
			return true;
		else
			return false;
	}

}
