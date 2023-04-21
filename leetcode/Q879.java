class Solution {
public int profitableSchemes(int n, int minProfit, int[] group, int[] profits) {
        int mod = 1000000007;
        int[][][] dp = new int[101][101][101];

        for(int count=0; count<=n; count++)
            dp[group.length][count][minProfit] = 1;

        for(int index=group.length-1; index>=0; index--)
        {
            for(int count=0; count<=n; count++)
            {
                for(int profit=0; profit<=minProfit; profit++)
                {
                    dp[index][count][profit] = dp[index+1][count][profit];

                    // 최소값만 넘으면 되므로 Math.min으로 minProfit에 합쳐준다.
                    if(count + group[index] <= n)
                    {
                        dp[index][count][profit] = (dp[index][count][profit] + dp[index+1][count+group[index]][Math.min(minProfit, profit+profits[index])]) % mod;
                    }
                }
            }
        }

        return dp[0][0][0];
    }
}