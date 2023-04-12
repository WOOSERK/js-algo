class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<Integer>[] whoTrustMe = new ArrayList[n+1];
        for(int i=0; i<=n; i++)
            whoTrustMe[i] = new ArrayList<>();

        boolean[] isNotJudge = new boolean[n+1];
        for(int[] t : trust)
        {
            int a = t[0];
            int b = t[1];

            whoTrustMe[b].add(a);
            isNotJudge[a] = true;
        }

        for(int i=1; i<=n; i++)
        {
            if(!isNotJudge[i] && whoTrustMe[i].size() == n-1)
                return i;
        }

        return -1;
    }
}