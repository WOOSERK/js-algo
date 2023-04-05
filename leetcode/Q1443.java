import java.util.*;

class Solution {
    boolean[] visited = new boolean[100001];
    ArrayList<Integer>[] list = new ArrayList[100001];

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        for(int i=0; i<n; i++)
            list[i] = new ArrayList<>();

        for(int[] edge: edges)
        {
            int a = edge[0];
            int b = edge[1];
            list[a].add(b);
            list[b].add(a);
        }

        int answer = 0;
        visited[0] = true;
        for(int next: list[0])
            answer += dfs(next, hasApple);

        return answer;
    }
    
    public int dfs(int id, List<Boolean> hasApple)
    {
        visited[id] = true;
        int count = 0;

        for(int next : list[id])
        {
            if(visited[next])
                continue;
            
            count += dfs(next, hasApple);
        }

        if(hasApple.get(id) || count > 0)
            return count + 2;

        return 0;
    }
}