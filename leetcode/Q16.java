class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int answer = 0;
        Arrays.sort(nums);
        
        for(int i=0; i<n-2; i++)
        {
            int l = i+1, r = n-1;

            while(l<r)
            {
                int sum = nums[i] + nums[l] + nums[r];
                if(target == sum)
                    return target;

                int d = Math.abs(sum - target);
                if(d < min)
                {
                    min = d;
                    answer = sum;
                }

                if(target < sum)
                    r--;
                else
                    l++;
            }
        }

        return answer;
    }
}