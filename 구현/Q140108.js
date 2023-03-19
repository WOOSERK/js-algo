function solution(s) 
{
    let answer = 0;
    let i = 0;
    while(i < s.length) 
    {
        const x = s[i];
        
        const cnt = [1, 0];
        while(i < s.length && cnt[0] !== cnt[1])
        {
            const ch = s[i+1];
            x === ch ? cnt[0]++ : cnt[1]++;
            i++;
        }
        
        s = s.substring(i+1);
        answer++;
        i = 0;
    }
    
    return answer;
}