function solution(n, m, section) 
{
    let lastPaint = section[0] - 1;
    let answer = 0;
    
    for(let i=0; i<section.length; i++)
    {
        if(lastPaint >= section[i])
            continue;
        
        lastPaint = section[i] + m - 1;
        answer++;
    }
    
    
    return answer;
}