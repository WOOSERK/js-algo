class Solution {
    public String[] strs = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<>();

        if(digits.isEmpty())
            return queue;

        queue.add("");
        while(queue.peek().length() != digits.length()) {
            String tmp = queue.poll();
            String str = strs[digits.charAt(tmp.length()) - '0'];

            for(char c : str.toCharArray())
                queue.add(tmp + c);
        }

        return queue;
    }
}