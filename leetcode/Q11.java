class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;

        while(i < j)
        {
            int tx = j - i, ty = 0;
            if(height[i] < height[j])
            {
                ty = height[i];
                i++;
            }
            else
            {
                ty = height[j];
                j--;
            }

            max = Integer.max(max, tx * ty);
        }

        return max;
    }
}