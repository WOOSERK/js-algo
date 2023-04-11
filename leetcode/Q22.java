class Solution {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(new StringBuilder(), 0, 0,n);
        return list;    
    }

    public void dfs(StringBuilder sb, int open, int close, int rem)
    {
        if(sb.length() == 2*rem) {
            list.add(sb.toString());
            return;
        }

        if(open < rem)
        {
            sb.append("(");
            dfs(sb, open + 1, close, rem);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open)
        {
            sb.append(")");
            dfs(sb, open, close + 1, rem);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}