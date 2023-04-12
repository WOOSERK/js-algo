class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] list = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++)
            list[i] = new ArrayList<>();

        int[] indeg = new int[numCourses];
        for(int[] p : prerequisites)
        {
            int a = p[0];
            int b = p[1];
            indeg[a]++;
            list[b].add(a);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++)
        {
            if(indeg[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty())
        {
            int tmp = queue.poll();

            for(int next: list[tmp])
            {
                indeg[next]--;
                if(indeg[next] == 0)
                    queue.add(next);
            }
        }
        
        for(int i=0; i<numCourses; i++)
        {
            if(indeg[i] != 0)
                return false;
        }

        return true;
    }
}