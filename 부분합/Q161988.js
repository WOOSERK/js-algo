function solution(sequence) 
{
    const sum = [[], []];
    let answer = Number.MIN_VALUE;
    
    for(let i=0; i<sequence.length; i++)
    {
        const id = i%2;
        
        if(i === 0)
        {
            sum[id].push(sequence[i]);
            sum[1-id].push(-sequence[i]);
            answer = Math.max(sequence[i], -sequence[i]);
            continue;
        }
        
        let prev = sum[id][i-1];
        let max = Math.max(sequence[i], prev + sequence[i]);
        sum[id].push(max);
        answer = Math.max(answer, max);
        
        prev = sum[1-id][i-1];
        max = Math.max(-sequence[i], prev - sequence[i]);
        sum[1-id].push(max);
        answer = Math.max(answer, max);
    }
    
    return answer;
}