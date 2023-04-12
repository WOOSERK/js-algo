class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int id = n-2;
        while(id >= 0)
        {
            if(nums[id] < nums[id+1])
                break;

            id--;
        }

        if(id >= 0)
        {
            int target = n-1;
            while(target > id)
            {
                if(nums[target] > nums[id])
                    break;
                
                target--;
            }


            int tmp = nums[target];
            nums[target] = nums[id];
            nums[id] = tmp;
        }

        int start = id+1;
        int end = n-1;
        while(start < end)
        {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;

            start++;
            end--;
        }
    }
}