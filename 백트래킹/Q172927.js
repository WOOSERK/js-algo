function solution(picks, minerals) 
{
    let answer = Number.MAX_VALUE;
    const pirodo = [
        {"diamond": 1, "iron": 1, "stone": 1},
        {"diamond": 5, "iron": 1, "stone": 1},
        {"diamond": 25, "iron": 5, "stone": 1}];
    
    const dfs = (depth, sum, id) => {
        const check = picks.every(v => v === 0);
        if(check || id === minerals.length)
        {
            answer = Math.min(answer, sum);
            return;
        }
        
        for(let i=0; i<3; i++)
        {
            if(picks[i] === 0)
                continue;
            
            let tid = id;
            let tsum = sum;
            
            picks[i]--;
            for(; tid < minerals.length && tid < id+5; tid++)
                tsum += pirodo[i][minerals[tid]];
            
            dfs(depth+1, tsum, tid);
            picks[i]++;
        }
    };
    
    dfs(0, 0, 0);
    
    return answer;
}