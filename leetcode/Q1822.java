class Solution {
    public int arraySign(int[] nums) {
        int minus = 0;
    
        for(int num : nums)
        {
            if(num == 0)
                return 0;
            
            if(num < 0)
                minus++;
        }

        return minus % 2 == 0 ? 1 : -1;
    }
}