class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(nums.length, (a, b) -> a[1] - b[1]);
        int[] cnt = new int[n];
        Arrays.fill(cnt, Integer.MAX_VALUE);

        pq.add(new int[]{0, 0});
        cnt[0] = 0;
        while(!pq.isEmpty())
        {
            int[] tmp = pq.poll();
            int cur = tmp[0];

            for(int i=nums[cur]; i>0; i--)
            {
                if(cur + i >= n || cnt[cur + i] <= tmp[1] + 1)
                    continue;
                
                cnt[cur + i] = tmp[1] + 1;
                if(cur + i == n-1)
                    return cnt[n-1];

                pq.add(new int[]{cur + i, cnt[cur + i]});
            }
        }

        return 0;
    }
}