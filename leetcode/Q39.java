class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public void backtracking(List<List<Integer>> list, List<Integer> tmplist, int[] candidates, int target, int start)
    {
        if(target < 0)
            return;
        else if(target == 0)
        {
            list.add(new ArrayList<>(tmplist));
            return;
        }

        for(int i=start; i<candidates.length; i++)
        {
            if(i > start && candidates[i] == candidates[i-1]) continue;

            tmplist.add(candidates[i]);
            backtracking(list, tmplist, candidates, target - candidates[i], i);
            tmplist.remove(tmplist.size() - 1);
        }
    }
}