class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;

        for(int i=0, j=0; j<s.length(); j++)
        {
            char ch = s.charAt(j);
            if(map.containsKey(ch))
                i = Math.max(map.get(ch), i);

            ans = Math.max(ans, j - i + 1);
            map.put(ch, j + 1);
        }

        return ans;
    }
}