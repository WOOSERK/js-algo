class Solution {
    public void sortColors(int[] nums) 
    {
        int red = 0, white = 0, blue = nums.length - 1;

        while(white <= blue)
        {
            if(nums[white] == 0)
            {
                if(nums[white] != nums[red])
                {
                    nums[white] ^= nums[red];
                    nums[red] ^= nums[white];
                    nums[white] ^= nums[red];
                }
                white++;
                red++;
            }
            else if(nums[white] == 1)
                white++;
            else
            {
                if(nums[white] != nums[blue])
                {
                    nums[white] ^= nums[blue];
                    nums[blue] ^= nums[white];
                    nums[white] ^= nums[blue];
                }
                blue--;
            }
        }
    }
}