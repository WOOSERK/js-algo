function solution(t, p) 
{
    let id = 0;
    let answer = 0;
    const np = Number(p);
    while(id + p.length <= t.length)
    {
        const num = Number(t.substring(id, id+p.length));
        if(num <= np)
            answer++;
        
        id++;
    }
    
    return answer;
}