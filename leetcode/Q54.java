class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> answer = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return answer;

        int up = 0, down = n-1;
        int left = 0, right = m-1;

        while(answer.size() < n*m)
        {
            for(int i=left; i<=right && answer.size() < n*m; i++)
                answer.add(matrix[up][i]);

            for(int i=up+1; i<=down-1 && answer.size() < n*m; i++)
                answer.add(matrix[i][right]);

            for(int i=right; i>=left && answer.size() < n*m; i--)
                answer.add(matrix[down][i]);

            for(int i=down-1; i>=up+1 && answer.size() < n*m; i--)
                answer.add(matrix[i][left]);

            left++; right--; up++; down--;
        }

        return answer;
    }
}