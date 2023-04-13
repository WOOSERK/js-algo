import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=0; i<=n; i++)
            list[i] = new ArrayList<>();
        
        for(int[] e : edge)
        {
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 0;
        
        int answer = 0;
        int max = 0;
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();
            
            for(int next : list[tmp])
            {
                if(dist[next] <= dist[tmp] + 1)
                    continue;
                
                dist[next] = dist[tmp] + 1;
                if(dist[next] > max)
                {
                    max = dist[next];
                    answer = 1;
                }
                else if(dist[next] == max)
                    answer++;
                
                queue.add(next);
            }
        }
        
        return answer;
    }
}