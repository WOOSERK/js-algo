function solution(number, limit, power) 
{
    const cnt = new Array(number + 1).fill(0);
    for(let i=1; i<=number; i++)
    {
        for(let j=1; j<=number/i; j++)
            cnt[i*j]++;
    }
    
    let answer = 0;
    for(let i=1; i<=number; i++)
        answer += cnt[i] <= limit ? cnt[i] : power;

    return answer;
}