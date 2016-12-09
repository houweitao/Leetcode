package hou.forme.GooglePrepare.GooglePrepare.hard;

/**
 * @author houweitao
 * @date 2016年12月9日下午3:53:26
 * @url https://discuss.leetcode.com/topic/60418/java-solution-using-priorityqueue/2
 */

public class TrappingRainWaterII {
	// public int trapRainWater(int[][] heightMap) {
	// if (heightMap == null || heightMap.length < 2)
	// return 0;
	//
	// int[][] up = new int[heightMap.length][heightMap[0].length];
	// int[][] down = new int[heightMap.length][heightMap[0].length];
	// int[][] left = new int[heightMap.length][heightMap[0].length];
	// int[][] right = new int[heightMap.length][heightMap[0].length];
	//
	// for (int i = 0; i < up[0].length; i++) {
	// int max = 0;
	// for (int j = 0; j < up.length; j++) {
	// up[j][i] = max;
	// max = Math.max(heightMap[j][i], max);
	// }
	// }
	// for (int i = 0; i < down[0].length; i++) {
	// int max = 0;
	// for (int j = down.length - 1; j >= 0; j--) {
	// down[j][i] = max;
	// max = Math.max(heightMap[j][i], max);
	// }
	// }
	//
	// for (int i = 0; i < left.length; i++) {
	// int max = 0;
	// for (int j = 0; j < left[0].length; j++) {
	// left[i][j] = max;
	// max = Math.max(max, heightMap[i][j]);
	// }
	// }
	// for (int i = 0; i < left.length; i++) {
	// int max = 0;
	// for (int j = left[0].length - 1; j >= 0; j--) {
	// right[i][j] = max;
	// max = Math.max(max, heightMap[i][j]);
	// }
	// }
	//
	// int sum = 0;
	// for (int i = 0; i < heightMap.length; i++) {
	// for (int j = 0; j < heightMap[0].length; j++) {
	// sum += Math.max(
	// Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j],
	// down[i][j])) - heightMap[i][j],
	// 0);
	// }
	// }
	//
	// return sum;
	// }
}
