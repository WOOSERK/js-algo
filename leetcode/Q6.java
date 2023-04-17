class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;

        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++)
            sbs[i] = new StringBuilder();

        int j=0;
        boolean flag = false;
        for(int i=0; i<s.length(); i++)
        {
            sbs[j].append(s.charAt(i));
            if(j == 0 || j == numRows - 1)
                flag = !flag;

            if(flag)
                j++;
            else
                j--;
        }

        StringBuilder answer = new StringBuilder();
        for(int i=0; i<numRows; i++)
            answer.append(sbs[i].toString());

        return answer.toString();
    }
}