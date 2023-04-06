class Solution {
    public int closedIsland(int[][] grid) {
        int[] dr = new int[]{-1, 0, 0, 1};
        int[] dc = new int[]{0, -1, 1, 0};

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();

        int gcnt = 0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(visited[i][j] || grid[i][j] == 1)
                    continue;
                
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                boolean isClosed = true;
                while(!queue.isEmpty())
                {
                    int[] tmp = queue.poll();

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

                        if(visited[newR][newC] || grid[newR][newC] == 1)
                            continue;

                        queue.add(new int[]{newR, newC});
                        visited[newR][newC] = true;
                    }
                }

                if(isClosed)
                    gcnt++;
            }
        }

        return gcnt;
    }
}