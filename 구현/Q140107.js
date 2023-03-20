function solution(k, d) 
{
    let answer = 0;
    let c = -k;
    for(let r=d; r>=0; r-=k)
    {
        c += k;
        answer += Math.floor(Math.sqrt(d ** 2 - c ** 2)/k) + 1;
    }
    
    return answer;
}