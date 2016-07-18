//package hou.forwz.Leetcode.hard;
//
///**
// * @author houweitao
// * @date 2016年7月18日下午10:01:12
// */
//
//public class Candy {
//
//	public int candy(int[] ratings) {
//		int n = ratings.length;
//		int[][] count = new int[n + 1][n + 1];
//
//		for (int i = 1; i <= n; i++) {
//			count[i][i] = 1;
//		}
//
//		for (int i = 1; i < n; i++) {
//			if (ratings[i] == ratings[i + 1])
//				count[i][i + 1] = 1;
//			else
//				count[i][i + 1] = 3;
//		}
//
//		for (int i = n; i >= 1; i--) {
//			for (int j = i + 2; j <= n; j++) {
//				count[i][j]=1;
//				
//				if(ratings[j]<ratings[j-1]){
//					if()
//				}
//			}
//		}
//	}
//
//}
