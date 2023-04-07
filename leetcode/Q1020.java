class Solution {
    public int numEnclaves(int[][] grid) {
        int answer = 0;
        int[] dr = new int[]{-1, 0, 0, 1};
        int[] dc = new int[]{0, -1, 1, 0};
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j] == 0 || isVisited[i][j])
                    continue;
                
                queue.add(new int[]{i, j});
                isVisited[i][j] = true;
                boolean isClosed = true;
                int cnt = 0;

                while(!queue.isEmpty())
                {
                    int[] tmp = queue.poll();
                    cnt++;
                    for(int k=0; k<4; k++)
                    {
                        int newR = tmp[0] + dr[k];
                        if(newR < 0 || newR >= grid.length)
                        {
                            isClosed = false;
                            continue;
                        }
                        int newC = tmp[1] + dc[k];
                        if(newC < 0 || newC >= grid[0].length)
                        {
                            isClosed = false;
                            continue;
                        }

                        if(grid[newR][newC] == 0 || isVisited[newR][newC])
                            continue;

                        queue.add(new int[]{newR, newC});
                        isVisited[newR][newC] = true;
                    }
                }

                if(isClosed)
                    answer += cnt;
            }
        }
        return answer;
    }
}