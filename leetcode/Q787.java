class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] list = new ArrayList[101];
        for(int i=0; i<=n; i++)
            list[i] = new ArrayList<>();

        for(int[] f : flights)
            list[f[0]].add(new int[]{f[1], f[2]});

        int[] values = new int[101];
        Arrays.fill(values, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(5001, (a, b) -> Integer.compare(a[1], b[1]));
        values[src] = 0;
        pq.add(new int[]{src, 0, -1});
        while(!pq.isEmpty())
        {
            int[] tmp = pq.poll();

            for(int[] next : list[tmp[0]])
            {
                if(values[next[0]] <= values[tmp[0]] + next[1] || tmp[2] + 1 > k)
                    continue;

                values[next[0]] = values[tmp[0]] + next[1];
                pq.add(new int[]{next[0], values[next[0]], tmp[2] + 1});
            }
        }

        return values[dst] == Integer.MAX_VALUE ? -1 : values[dst];
    }
}