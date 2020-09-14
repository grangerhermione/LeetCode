package dynamic_programming;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/coin-change/
 * 
 * Coin Change:
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int dp[]=new int[amount+1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0]=0;
        for(int i=1;i<amount+1;i++){
            for(int coin:coins){
                if(coin==i){
                    dp[i]=1;
                }
                else if(i>coin){
                    if(dp[i-coin]==Integer.MAX_VALUE){
                        continue;
                    }
                    dp[i]=Math.min(dp[i-coin]+1, dp[i]);
                    
                }
            }
        }
        
        return (dp[amount]==Integer.MAX_VALUE)?-1:dp[amount];
        
    }
}
