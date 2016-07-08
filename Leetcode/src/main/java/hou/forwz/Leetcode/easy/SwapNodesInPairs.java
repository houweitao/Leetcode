package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.ListNode;

/**
 *@author houweitao
 *@date 2016年7月8日下午9:18:24
 */

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
        	return head;
        else{
        	ListNode ret=new ListNode(-1);
        	
        	ListNode tmp=head.next.next;
        	ret.next=head.next;
        	ret.next.next=head;
        	head.next=swapPairs(tmp);
        	
        	return ret.next;
        }
    }



    public ListNode swapPairsNo(ListNode head) {
        if(head==null||head.next==null)
        	return head;
        else{
        	ListNode ret=new ListNode(-1);
        	ListNode help=ret;
        	
        	while(head!=null&&head.next!=null){
        		help.next=head.next;
        		help=help.next;
        		ListNode p=help.next;
        		help.next=head;
        		head.next=p;
        		head=head.next;
        	}
        	
        	help.next=head;
        	
        	return ret.next;
        }
    }

}
