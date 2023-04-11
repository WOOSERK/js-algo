class Solution {
    public int romanToInt(String s) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roms = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int answer = 0;
        int i=0, j=0;

        while(i < values.length)
        {
            int id = s.indexOf(roms[i], j);
            if(id != j)
                i++;
            else
            {
                j += roms[i].length();
                answer += values[i];
            }
        }

        return answer;
    }
}