class Solution {
    public int[] answer = new int[]{Integer.MAX_VALUE, -1};

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1, -1};

        binarySearch(nums, 0, nums.length-1, target);
        
        answer[0] = answer[0] == Integer.MAX_VALUE ? -1 : answer[0];
        return answer;
    }

    public void binarySearch(int[] nums, int start, int end, int target)
    {
        if(start > end)
            return;

        int pivot = (start + end) / 2;
        if(nums[pivot] > target)
            binarySearch(nums, start, pivot-1, target);
        else if(nums[pivot] < target)
            binarySearch(nums, pivot+1, end, target);
        else
        {
            answer[0] = Math.min(answer[0], pivot);
            answer[1] = Math.max(answer[1], pivot);
            binarySearch(nums, start, pivot-1, target);
            binarySearch(nums, pivot+1, end, target);
        }
    }
}