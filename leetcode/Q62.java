class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        dp[0][0] = 1;
        int[] dr = new int[]{0, 1};
        int[] dc = new int[]{1, 0};
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                for(int k=0; k<2; k++)
                {
                    int newR = i + dr[k];
                    if(newR >= m)
                        continue;
                    int newC = j + dc[k];
                    if(newC >= n)
                        continue;

                    dp[newR][newC] += dp[i][j];
                }
            }
        }

        return dp[m-1][n-1];
    }
}