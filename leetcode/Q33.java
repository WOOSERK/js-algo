class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0, right = n-1;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            
            // 두 번째 오름차순 리스트
            if(nums[mid] < nums[left])
            {
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else // 첫 오름차순 리스트
            {
                if(target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }

        return -1;
    }
}