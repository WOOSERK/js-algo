function solution(s) 
{
    const obj = {};
    const answer = [];
    for(let i=0; i<s.length; i++)
    {
        const ch = s[i];
        answer.push(obj[ch] >= 0 ? i - obj[ch] : -1)
        
        obj[ch] = i;
    }
    
    return answer;
}