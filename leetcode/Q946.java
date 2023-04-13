class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=0;

        Stack<Integer> st = new Stack<>();
        for(int j=0; j<pushed.length; j++)
        {
            st.push(pushed[j]);
            while(!st.isEmpty() && i < popped.length)
            {
                if(popped[i] != st.peek())
                    break;

                st.pop();
                i++;
            }
        }

        return st.isEmpty();
    }
}