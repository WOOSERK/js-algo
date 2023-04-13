class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++)
        {
            Arrays.fill(dist[i], 10000000);
            dist[i][i] = 0;
        }

        for(int[] e : edges)
        {
            int a = e[0];
            int b = e[1];
            dist[a][b] = e[2];
            dist[b][a] = e[2];
        }

        for(int k=0; k<n; k++)
        {
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int answer = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            int cnt = 0;
            for(int j=0; j<n; j++)
            {
                if(dist[i][j] <= distanceThreshold)
                    cnt++;
            }

            if(cnt <= min)
            {
                min = cnt;
                answer = i;
            }
        }

        return answer;
    }
}