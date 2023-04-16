class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] sum = new int[m][n];
        for(int i=0; i<m; i++)
            Arrays.fill(sum[i], Integer.MAX_VALUE);
            
        sum[0][0] = grid[0][0];
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i - 1 >= 0)
                    sum[i][j] = sum[i-1][j] + grid[i][j];

                if(j - 1 >= 0)
                    sum[i][j] = Math.min(sum[i][j], sum[i][j-1] + grid[i][j]);
            }
        }

        return sum[m-1][n-1];
    }
}