package hou.forwz.Leetcode.medium;

/**
 *@author houweitao
 *@date 2016年7月8日下午9:57:24
 */

public class DivideTwoIntegers {

    public int divide(int dividen, int divisor) {
        boolean neg=false;
        long dividend=0;
        if(dividen*divisor<0){
            neg=true;
            dividend=dividen*-1;
        }
        
        if(dividend<divisor)
        	return 0;
        else if(dividend==divisor){
            if(!neg)
        	    return 1;
        	else
        	    return -1;
        }
        else{
        	int ret=0;
        	while(dividend>=divisor){
        		dividend=dividend-divisor;
        		ret++;
        	}
        	if(!neg)
        	    return ret;
        	else
        	    return -ret;
        }
    
    }

}
