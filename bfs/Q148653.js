function solution(storey) 
{
    const dg = Math.log10(Math.floor(storey));
    
    const queue = [];
    queue.push([storey, 0]);
    
    const visited = {};
    visited[storey] = 0;
    while(queue.length > 0)
    {
        const num = queue.shift();
        let tmp = num[0];
        if(Math.log10(Math.floor(tmp)) >= dg+1)
            continue;
        
        let digits = 0;
        while(tmp >= 10 && tmp % 10 === 0)
        {
            tmp /= 10;
            digits++;
        }
        
        const rem = tmp % 10;
        // 빼기
        let cnt = num[1] + rem;
        let next = num[0] - rem * 10 ** digits;
        if(!visited[next] || cnt < visited[next])
        {
            visited[next] = cnt;
            queue.push([next, cnt]);
        }
        
        // 더하기
        cnt = num[1] + (10 - rem);
        next = num[0] + (10 - rem) * 10 ** digits;
        if(!visited[next] || cnt < visited[next])
        {
            visited[next] = cnt;
            queue.push([next, cnt]);
        }
    }
    
    return visited[0];
}