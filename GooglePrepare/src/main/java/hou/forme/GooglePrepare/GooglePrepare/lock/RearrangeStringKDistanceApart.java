package hou.forme.GooglePrepare.GooglePrepare.lock;

/**
 * @author houweitao
 * @date 2016年12月16日下午1:54:38
 * @nice https://discuss.leetcode.com/topic/48260/java-15ms-solution-with-two-auxiliary-array-o-n-time
 * @bug 需要加一个变量记录最早出现位置。canshow http://www.programcreek.com/2014/08/leetcode-rearrange-string-k-distance-apart-java/
 */

public class RearrangeStringKDistanceApart {
	public static void main(String[] args) {
		RearrangeStringKDistanceApart rs = new RearrangeStringKDistanceApart();
		System.out.println(rs.rearrangeStringMe("aabbcc", 3));
	}

	public String rearrangeStringMe(String str, int k) {
		int len = str.length();
		int[] count = new int[26];
		int[] canShow = new int[26];

		for (int i = 0; i < len; i++) {
			int pos = str.charAt(i) - 'a';
			count[pos]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			int need = findNeedIndex(count, canShow, i);
			if (need == -1)
				return "";
			count[need]--;
			canShow[need] = i + k;
			char add = (char) ('a' + need);
			sb.append(add);
		}
		return sb.toString();
	}

	private int findNeedIndex(int[] count, int[] canShow, int index) {
		int ret = -1;
		int max = -1;

		for (int i = 0; i < 26; i++) {
			if (count[i] > 0 && count[i] > max && canShow[i] <= index) {
				ret = i;
				max = count[i];
			}
		}

		return ret;
	}

	public String rearrangeString(String str, int k) {
		int length = str.length();
		int[] count = new int[26];
		int[] valid = new int[26];
		for (int i = 0; i < length; i++) {
			count[str.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int index = 0; index < length; index++) {
			int candidatePos = findValidMax(count, valid, index);
			if (candidatePos == -1)
				return "";
			count[candidatePos]--;
			valid[candidatePos] = index + k;
			sb.append((char) ('a' + candidatePos));
		}
		return sb.toString();
	}

	private int findValidMax(int[] count, int[] valid, int index) {
		int max = Integer.MIN_VALUE;
		int candidatePos = -1;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0 && count[i] > max && index >= valid[i]) {
				max = count[i];
				candidatePos = i;
			}
		}
		return candidatePos;
	}
}
