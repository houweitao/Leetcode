package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author houweitao
 * @date 2016年7月27日下午9:11:38
 */

public class DesignTwitter {
	public static void main(String[] args) {
		DesignTwitter dt = new DesignTwitter();
		dt.init();
	}

	private void init() {
		Twitter t = new Twitter();
		t.postTweet(1, 5);
		System.out.println(t.getNewsFeed(1));
		t.follow(1, 2);
		t.postTweet(2, 6);
		System.out.println(t.getNewsFeed(1));
		t.unfollow(1, 2);
		System.out.println(t.getNewsFeed(1));

	}

	class Twitter {

		// int userId;
		// List<Integer> twitters;
		// List<Integer> followers;

		class Tweet {
			int time;
			int id;

			Tweet(int time, int id) {
				this.time = time;
				this.id = id;
			}
		}

		Map<Integer, List<Integer>> peoppleTwitters;
		Map<Integer, List<Integer>> follow;

		/** Initialize your data structure here. */
		public Twitter() {
			follow = new HashMap<>();
			peoppleTwitters = new HashMap<>();
		}

		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			if (peoppleTwitters.containsKey(userId)) {
				peoppleTwitters.get(userId).add(tweetId);
			} else {
				List<Integer> tmp = new LinkedList<>();
				tmp.add(tweetId);
				peoppleTwitters.put(userId, tmp);
			}

		}

		/**
		 * Retrieve the 10 most recent tweet ids in the user's news feed. Each
		 * item in the news feed must be posted by users who the user followed
		 * or by the user herself. Tweets must be ordered from most recent to
		 * least recent.
		 */
		public List<Integer> getNewsFeed(int userId) {
			List<Integer> ret = new ArrayList<>();
			List<Integer> follows = follow.get(userId);
			TreeMap<Integer, Integer> map = new TreeMap<>();

			if (follows != null)
				for (int i = 0; i < follows.size(); i++) {
					int curUser = follows.get(i);
					List<Integer> curTwetters = peoppleTwitters.get(curUser);
					if (curTwetters != null)
						for (int j = 9; j >= 0; j--) {
							if (j < curTwetters.size())
								map.put(curTwetters.get(j), 1);
						}
				}
			List<Integer> twitters = peoppleTwitters.get(userId);
			if (twitters != null)
				for (int i = 9; i >= 0; i--) {
					if (i < twitters.size())
						map.put(twitters.get(i), 1);
				}

			// System.out.println("all: " + map.size());

			Set<Integer> set = map.descendingKeySet();
			for (Integer i : set) {
				ret.add(i);
				if (ret.size() == 10)
					break;
			}

			return ret;

		}

		/**
		 * Follower follows a followee. If the operation is invalid, it should
		 * be a no-op.
		 */
		public void follow(int followerId, int followeeId) {

			if (follow.containsKey(followerId)) {
				follow.get(followerId).add(followeeId);
			} else {
				follow.put(followerId, new LinkedList<Integer>());
				follow.get(followerId).add(followeeId);
			}

		}

		/**
		 * Follower unfollows a followee. If the operation is invalid, it should
		 * be a no-op.
		 */
		public void unfollow(int followerId, int followeeId) {
			List<Integer> list = follow.get(followerId);
			if (list != null)
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) == followeeId) {
						list.remove(i);
						break;
					}
				}
		}
	}

	/**
	 * Your Twitter object will be instantiated and called as such: Twitter obj
	 * = new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
	 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
	 * obj.unfollow(followerId,followeeId);
	 */
}
