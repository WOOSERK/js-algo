class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        int n = nums.length;
        int jump = 0;

        for(int i=0; i<=Math.min(n-1, farthest); i++)
        {
            if(i == farthest)
                jump++;
            
            farthest = Math.max(farthest, i + nums[i]);
        }

        return farthest >= n-1;
    }
}