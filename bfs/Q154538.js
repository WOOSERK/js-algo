function solution(x, y, n) 
{
    if(x === y)
        return 0;
    
    const visited = {};
    visited[x] = 0;
    
    let data = [x];
    while(data.length)
    {
        const newData = [];
        for(const d of data)
        {
            for(const e of [d+n, 2*d, 3*d])
            {
                if(e > y || visited[e])
                    continue;
                else if(e === y)
                    return visited[d] + 1;

                visited[e] = visited[d] + 1;
                newData.push(e);
            }
        }
        
        data = newData;
    }
    
    return -1;
}