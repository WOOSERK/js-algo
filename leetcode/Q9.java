class Solution {
    public boolean isPalindrome(int x) {
        String s = x + "";
        String tmp = new StringBuffer(s).reverse().toString();

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) != tmp.charAt(i))
                return false;
        }

        return true;
    }
}