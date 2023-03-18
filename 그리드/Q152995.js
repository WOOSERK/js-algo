function solution(scores) 
{
    const wanho = scores[0];
    const arr = scores.sort((a, b) => a[0] === b[0] ? a[1] - b[1] : b[0] - a[0]);
    
    let maxScore = 0;
    let answer = 1;
    for(const s of scores)
    {
        if(s[1] < maxScore)
        {
            if(s === wanho)
                return -1;
        }
        else
        {
            maxScore = Math.max(maxScore, s[1]);
            if(s[0] + s[1] > wanho[0] + wanho[1])
                answer++;
        }
    }
    
    return answer;
}