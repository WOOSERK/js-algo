class Solution {
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        int answer = 1;

        while(left < right)
        {
            int mid = left + (right - left) / 2;

            double floor = Math.sqrt(n - mid/2.0) * Math.sqrt(2);
            if(floor < mid)
                right = mid;
            else
            {
                left = mid + 1;
                answer = (int)floor;
            }
        }

        return answer;
    }
}