class Pair implements Comparable<Pair>
{
    int cur;
    double value;

    public Pair(int cur, double value)
    {
        this.cur = cur;
        this.value = value;
    }

    public int compareTo(Pair p)
    {
        return Double.compare(p.value, this.value);
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<Pair>[] list = new ArrayList[n];        
        for(int i=0; i<n; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<edges.length; i++)
        {
            list[edges[i][0]].add(new Pair(edges[i][1], succProb[i]));
            list[edges[i][1]].add(new Pair(edges[i][0], succProb[i]));
        }

        double[] values = new double[n];
        Arrays.fill(values, Double.MIN_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 1));
        values[start] = 1;

        while(!pq.isEmpty())
        {
            Pair tmp = pq.poll();

            for(Pair next : list[tmp.cur])
            {
                if(values[next.cur] >= tmp.value * next.value)
                    continue;

                values[next.cur] = tmp.value * next.value;
                pq.add(new Pair(next.cur, values[next.cur]));
            }
        }

        return values[end] == Double.MAX_VALUE ? 0 : values[end];
    }
}