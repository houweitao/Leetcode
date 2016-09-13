package hou.forwz.LeetcodeAgain.easy;

/**
 *@author houweitao
 *@date 2016年9月13日下午11:38:26
 */

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int ret=0;
        for(int i=1;i<prices.length;i++){
        	if(prices[i]>prices[i-1])
        		ret+=prices[i]-prices[i-1];
        }
        return ret;
    }

}
