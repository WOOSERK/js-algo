function solution(nums) 
{
    const set = new Set();
    
    nums.forEach(v => set.add(v));
    return Math.min(set.size, nums.length/2);
}