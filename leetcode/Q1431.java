class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> list = new ArrayList<>();
        for(int candy : candies)
            max = Math.max(max, candy);

        max -= extraCandies;
        for(int candy : candies)
            list.add(candy >= max);

        return list;
    }
}