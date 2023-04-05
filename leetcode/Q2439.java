class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0;
        long answer = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum += nums[i];
            answer = Math.max(answer, (sum+i) / (i+1));
        }

        return (int)answer;
    }
}