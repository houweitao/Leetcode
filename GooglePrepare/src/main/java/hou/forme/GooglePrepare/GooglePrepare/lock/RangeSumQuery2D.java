package hou.forme.GooglePrepare.GooglePrepare.lock;

/**
 * @author houweitao
 * @date 2016年12月3日下午1:48:47
 * @problem http://www.cnblogs.com/grandyang/p/5300458.html
 * @end 2016年12月03日14:17:32
 */

/*
 * Example: Given matrix = [ [3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7], [1, 0, 3, 0, 5] ] sumRegion(2, 1, 4, 3) -> 8 update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10 Note: The matrix is only modifiable by the update
 * function. You may assume the number of calls to update and sumRegion function
 * is distributed evenly. You may assume that row1 ≤ row2 and col1 ≤ col2.
 */

public class RangeSumQuery2D {
	int[][] matrix;

	int sumRegion(int upX, int upY, int downX, int downY) {
		Node root = buildNode(matrix, upX, upY, downX, downY);
		return help(root, downY, downY, downY, downY);
	}

	void update(Node node, int x, int y, int val) {
		if (node != null && x >= node.upX && x <= node.downX && x <= node.downY && x >= node.upY) {
			if (node.upX == node.downX && node.upX == x && node.upY == node.downY && node.downY == y) {
				node.sum = val;
			} else {
				update(node.leftUp, x, y, val);
				update(node.leftDown, x, y, val);
				update(node.rightUp, x, y, val);
				update(node.rightDown, x, y, val);
				node.build(node.leftUp, node.leftDown, node.rightUp, node.rightDown);
			}
		}
	}

	private int help(Node root, int upX, int upY, int downX, int downY) {
		if (root == null || root.upX > downX || root.downX < upX || root.downY < upY || root.downX > upX)
			return 0;
		else if (upX <= root.upX && upY <= root.upY && downX >= root.downX && downY >= root.downY) {
			return root.sum;
		} else {
			return help(root.leftUp, upX, upY, downX, downY) + help(root.leftDown, upX, upY, downX, downY)
					+ help(root.rightDown, upX, upY, downX, downY) + help(root.rightUp, upX, upY, downX, downY);
		}
	}

	Node buildNode(int[][] matrix, int upX, int upY, int downX, int downY) {
		if (upX > downX || upY > downY)
			return null;
		else if (upX == downX && upY == downY) {
			Node ret = new Node(upX, upY, downX, downY);
			ret.sum = matrix[upX][upY];
			return ret;
		} else {
			Node ret = new Node(upX, upY, downX, downY);
			int midX = (upX + downX) / 2;
			int midY = (upY + downY) / 2;

			Node leftUp = new Node(upX, midX, midY, downY);
			Node leftDown = new Node(midX + 1, upY, downX, midY);
			Node rightUp = new Node(upX, midY + 1, midX, downY);
			Node rightDown = new Node(midX + 1, midY + 1, downX, downY);

			ret.build(leftUp, leftDown, rightUp, rightDown);
			return ret;
		}
	}

	class Node {
		int sum;
		int upX, upY, downX, downY;
		Node leftUp, rightUp, leftDown, rightDown;

		public Node(int upX, int upY, int downX, int downY) {
			super();
			this.upX = upX;
			this.upY = upY;
			this.downX = downX;
			this.downY = downY;
		}

		public void build(Node leftUp, Node leftDown, Node rightUp, Node rightDown) {
			this.leftUp = leftUp;
			this.leftDown = leftDown;
			this.rightDown = rightDown;
			this.rightUp = rightUp;
			this.sum = getSum(leftUp) + getSum(leftDown) + getSum(rightUp) + getSum(rightDown);
		}

		int getSum(Node node) {
			if (node == null)
				return 0;
			else
				return node.sum;
		}
	}
}
