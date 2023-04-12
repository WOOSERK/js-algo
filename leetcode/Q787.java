class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] list = new ArrayList[101];
        for(int i=0; i<=n; i++)
            list[i] = new ArrayList<>();

        for(int[] f : flights)
            list[f[0]].add(new int[]{f[1], f[2]});

        int[][] values = new int[101][k+2];
        for(int i=0; i<=n; i++)
           Arrays.fill(values[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(5001, (a, b) -> Integer.compare(a[1], b[1]));
        values[src][0] = 0;
        pq.add(new int[]{src, 0, 0});
        while(!pq.isEmpty())
        {
            int[] tmp = pq.poll();
            int cur = tmp[0];
            int value = tmp[1];
            int cnt = tmp[2];

            for(int[] next : list[cur])
            {
                if(cnt > k || values[next[0]][cnt+1] <= values[cur][cnt] + next[1])
                    continue;

                values[next[0]][cnt+1] = values[cur][cnt] + next[1];
                pq.add(new int[]{next[0], values[next[0]][cnt+1], cnt + 1});
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int value : values[dst])
            answer = Math.min(answer, value);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}