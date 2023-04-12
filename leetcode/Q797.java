class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new ArrayList<>(), 0, graph);

        return answer;
    }

    public void dfs(List<List<Integer>> answer, List<Integer> path, int id, int[][] graph)
    {
        if(id == graph.length - 1)
        {
            path.add(id);
            answer.add(new ArrayList<>(path));
            return;
        }

        for(int next : graph[id])
        {
            path.add(id);
            dfs(answer, new ArrayList<>(path), next, graph);
            path.remove(path.size() - 1);
        }
    }
}