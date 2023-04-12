class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] isVisit = new boolean[n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        isVisit[0] = true;
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();

            for(int room : rooms.get(tmp))
            {
                if(isVisit[room])
                    continue;
                
                isVisit[room] = true;
                queue.add(room);
            }
        }

        for(int i=0; i<n; i++)
        {
            if(!isVisit[i])
                return false;
        }

        return true;
    }
}