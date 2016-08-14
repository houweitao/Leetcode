package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
/  @author houweitao
/  @date 2016年8月15日上午1:44:10
*/
public class MiniParser {

//	public NestedInteger deserialize(String s) {
//		NestedInteger ret=new NestedInteger();
//		if(s.charAt(0)!='['){
//			int pos=s.indexOf(',');
//			if(pos!=-1){
//				int num=Integer.valueOf(s.substring(0,pos));
//				ret.setInteger(num);
//				
//				String remain=s.substring(pos+1);
//				
//			}
//			
//			
//		}
//	
//	
//	
//	}


	class NestedInteger {
		Integer value;
		List<NestedInteger> list;

		// Constructor initializes an empty nested list.
		NestedInteger() {
			list = new ArrayList<>();
		}

		// Constructor initializes a single integer.
		NestedInteger(int value) {
			this.value = value;
			list = new ArrayList<>();
		}

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		boolean isInteger() {
			return list.size() == 0;
		}

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		Integer getInteger() {
			return value;
		}

		// Set this NestedInteger to hold a single integer.
		void setInteger(int value) {
			this.value = value;
		}

		// Set this NestedInteger to hold a nested list and adds a nested
		// integer to it.
		void add(NestedInteger ni) {
			list.add(ni);
		}

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		List<NestedInteger> getList() {
			if (list.size() == 0)
				return null;
			else
				return list;
		}
	}
}
