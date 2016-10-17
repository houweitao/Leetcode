package hou.enjoy.HackerRank.medium;

import java.util.Scanner;

/**
 * @author houweitao
 * @date 2016年10月17日上午10:48:36
 * @url https://www.hackerrank.com/challenges/candies
 * @tips 可能溢出
 */

//Sample Input
//
//3  
//1  
//2  
//2
//Sample Output
//
//4

public class Candies {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] scores = new int[num];
		for (int i = 0; i < num; i++) {
			scores[i] = scanner.nextInt();
		}

		int[] candies = new int[num];
		candies[0] = 1;
		for (int i = 1; i < num; i++) {
			if (scores[i] > scores[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				candies[i] = 1;
			}
		}

		for (int i = num - 2; i >= 0; i--) {
			if (scores[i] > scores[i + 1]) {
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
		}

		long sum = 0;
		for (int i : candies) {
			sum += i;
		}
		System.out.println(sum);
	}
}
