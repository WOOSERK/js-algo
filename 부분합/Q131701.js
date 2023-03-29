function solution(elements) 
{
    const answer = new Set();
    const e = [...elements, ...elements];
    
    for(let start=0; start<elements.length; start++)
    {
        let sum = 0;
        for(let i=0; i<elements.length; i++)
        {
            sum += e[start + i];
            answer.add(sum);
        }
    }
    
    return answer.size;
}