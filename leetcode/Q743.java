class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(6000, (a, b) -> Integer.compare(a[1], b[1]));
        List<int[]>[] list = new ArrayList[n+1];
        for(int i=0; i<=n; i++)
            list[i] = new ArrayList<>();

        for(int[] t : times)
            list[t[0]].add(new int[]{t[1], t[2]});

        int[] values = new int[n+1];
        Arrays.fill(values, Integer.MAX_VALUE);
        values[k] = 0;
        queue.add(new int[]{k, 0});
        while(!queue.isEmpty())
        {
            int cur = queue.poll()[0];

            for(int[] next : list[cur])
            {
                if(values[next[0]] <= values[cur] + next[1])
                    continue;

                values[next[0]] = values[cur] + next[1];
                queue.add(new int[]{next[0], values[next[0]]});
            }
        }

        int answer = 0;
        for(int i=1; i<=n; i++)
            answer = Math.max(answer, values[i]);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}