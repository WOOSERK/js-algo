class Solution {
    public String simplifyPath(String path) {
        String[] p = path.split("/");
        StringBuilder sb = new StringBuilder();

        Stack<String> st = new Stack<>();
        for(String s : p)
        {
            switch(s)
            {
                case "":
                case ".":
                    break;

                case "..":
                    if(!st.isEmpty()) 
                        st.pop();
                    break;

                default:
                    st.push(s);
                    break;
            }
        }

        for(String s : st)
            sb.append("/").append(s);

        if(sb.isEmpty())
            sb.append("/");
            
        return sb.toString();
    }
}