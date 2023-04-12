class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] list = new ArrayList[101];
        for(int i=0; i<=n; i++)
            list[i] = new ArrayList<>();

        for(int[] f : flights)
            list[f[0]].add(new int[]{f[1], f[2]});

        int[] stops = new int[101];
        Arrays.fill(stops, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(5001, (a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{src, 0, 0});
        while(!pq.isEmpty())
        {
            int[] tmp = pq.poll();
            int cur = tmp[0];
            int value = tmp[1];
            int cnt = tmp[2];

            if(cnt > stops[cur] || cnt > k + 1)
                continue;

            stops[cur] = cnt;
            if(cur == dst)
                return value;

            for(int[] next : list[cur])
                pq.add(new int[]{next[0], value + next[1], cnt + 1});
        }

        return -1;
    }
}