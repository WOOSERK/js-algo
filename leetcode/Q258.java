class Solution {
    public int addDigits(int num) {
        while(num >= 10)
        {
            String tmp = num + "";
            int sum = 0;

            for(int i=0; i<tmp.length(); i++)
                sum += tmp.charAt(i) - '0';

            num = sum;
        }

        return num;
    }
}