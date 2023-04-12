class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String answer = null;

        for(int start=len; start>=0; start--)
        {
            for(int end=start; end<len; end++)
            {
                if(s.charAt(start) == s.charAt(end) && (end - start < 3 || dp[start+1][end-1]))
                    dp[start][end] = true;

                if(dp[start][end] && (answer == null || end - start + 1 > answer.length()))
                    answer = s.substring(start, end+1);
            }
        }

        return answer;
    }
}