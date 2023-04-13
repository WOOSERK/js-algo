class Solution {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] isVisit = new boolean[len];

        int answer = 0;
        pq.add(new int[]{0, 0});
        while(!pq.isEmpty())
        {
            int[] tmp = pq.poll();
            if(isVisit[tmp[0]])
                continue;

            isVisit[tmp[0]] = true;
            answer += tmp[1];
            for(int i=0; i<len; i++)
            {
                if(isVisit[i])
                    continue;

                int[] target = points[i];
                int[] cur = points[tmp[0]];
                int d = Math.abs(target[0] - cur[0]) + Math.abs(target[1] - cur[1]);

                pq.add(new int[]{i, d});
            }
        }

        return answer;
    }
}