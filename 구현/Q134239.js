function solution(k, ranges) 
{
    let x = 0;
    const co = [[x, k]];
    while(k !== 1)
    {
        k = k % 2 === 0 ? k/2 : 3*k+1;
        co.push([++x, k]);
    }
    
    const area = [];
    co.reduce((acc, cur, id) => {
        if(id === 0)
        {
            area.push(0);
            return acc;
        }
        
        let [x1, y1] = co[id];
        let [x2, y2] = co[id-1];
        if(x2 > x1)
        {
            const tmp = x2;
            x2 = x1;
            x1 = tmp;
        }
        if(y2 > y1)
        {
            const tmp = y2;
            y2 = y1;
            y1 = tmp;
        }
        
        acc += (y1-y2)/2 + y2;
        area.push(acc);
        return acc;
    }, 0);
    
    const answer = ranges.map(v => {
        let sx = v[0];
        let ex = co.length + v[1] - 1;
        
        if(sx > ex)
            return -1;
        
        const sum = area[ex] - area[sx];
        
        return sum;
    });
    
    return answer;
}