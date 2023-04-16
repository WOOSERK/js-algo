class Solution {
    public int numWays(String[] words, String target) {
        int m = target.length(), k = words[0].length();
        int mod = 1000000007;

        int[][] cnt = new int[26][k];
        for(int j=0; j<k; j++)
        {
            for(String word : words)
                cnt[word.charAt(j) - 'a'][j]++;
        }

        long[][] dp = new long[m+1][k+1];
        dp[0][0] = 1;
        for(int i=0; i<=m; i++)
        {
            for(int j=0; j<k; j++)
            {
                if(i < m)
                {
                    // 해당 알파벳이 j번째 인덱스에 몇 개 있는지 * j-1까지 길이 i의 접두사 해결 수
                    dp[i+1][j+1] += cnt[target.charAt(i) - 'a'][j] * dp[i][j];
                    dp[i+1][j+1] %= mod;
                }

                dp[i][j+1] += dp[i][j];
                dp[i][j+1] %= mod;
            }
        }

        return (int)dp[m][k];
    }
}