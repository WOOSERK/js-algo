function solution(X, Y) 
{
    const map1 = new Map();
    const map2 = new Map();
    
    X.split('').forEach(v => map1.set(v, map1.get(v) + 1 || 1));
    Y.split('').forEach(v => map2.set(v, map2.get(v) + 1 || 1));
    
    let answer = "";
    for(let i=9; i>=0; i--)
    {
        const v1 = map1.get(String(i)) || -1;
        const v2 = map2.get(String(i)) || -1;
        
        const minv = Math.min(v1, v2);
        if(minv === -1)
            continue;
            
        answer += String(i).repeat(i === 0 && answer === "" ? 1 : minv);
    }
    
    return answer === "" ? "-1" : answer;
}