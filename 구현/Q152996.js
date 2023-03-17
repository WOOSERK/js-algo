function solution(weights) 
{
    const arr = {};
    weights.forEach(i => arr[i] = arr[i] + 1 || 1);
    
    let cnt = 0;
    let self = 0;
    
    for(const p in arr)
    {
        const num = Number(p);
        if(arr[num] > 1)
            self += Math.round((arr[num] ** 2 - arr[num]) / 2);
                
        for(const e of [3/2*num, 2*num, 2/3*num, 4/3*num, num/2, 3/4*num])
        {
            if(arr[e])
                cnt += arr[num] * arr[e];
        }
    }
    
    return Math.floor(cnt/2) + self;
}