class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        int i=0;

        Loop:
        while(true)
        {
            char prev = 0;
            for(int j=0; j<strs.length; j++)
            {
                String str = strs[j];
                if(i >= str.length())
                    break Loop;

                if(prev == 0)
                    prev = str.charAt(i);
                else if(str.charAt(i) != prev)
                    break Loop;
            }

            i++;
            sb.append(prev);
        }

        return sb.toString();
    }
}