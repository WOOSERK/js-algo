class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minq = new PriorityQueue<>();

        int i = 0, j = 0;
        while(i < nums1.length || j < nums2.length)
        {
            int target = 0;
            if(i < nums1.length && j < nums2.length)
            {
                if(nums1[i] < nums2[j])
                    target = nums1[i++];
                else
                    target = nums2[j++];
            }
            else if(i < nums1.length)
                target = nums1[i++];
            else
                target = nums2[j++];
            
            minq.add(target);
            if(minq.size() > maxq.size())
                maxq.add(minq.poll());
        }

        System.out.println(nums1.length + nums2.length);
        if((nums1.length + nums2.length) % 2 == 1)
            return maxq.poll();

        return (maxq.poll() + minq.poll()) / 2.0;
    }
}