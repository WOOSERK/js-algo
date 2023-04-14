class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int left = 0, right = nums.length;
        while(left < right)
        {
            int mid = left + (right - left) / 2;

            if(mid < nums[mid])
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}