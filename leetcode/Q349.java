class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());

        List<Integer> answer = new ArrayList<>();
        Arrays.sort(nums2);

        Iterator<Integer> it = set.iterator();

        for(Integer i : set)
        {
            int left = 0, right = nums2.length;

            while(left < right)
            {
                int mid = left + (right - left) / 2;

                if(nums2[mid] == i)
                {
                    answer.add(i);
                    break;
                }
                else if(nums2[mid] > i)
                    right = mid;
                else
                    left = mid + 1;
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}