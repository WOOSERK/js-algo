function solution(cards) 
{
    const answer = [];
    for(let i=0; i<cards.length; i++)
    {
        if(cards[i] === -1)
            continue;
        
        let sum = 0;
        let id = i;
        while(cards[id] >= 0)
        {
            let next = cards[id] - 1;
            cards[id] = -1;
            sum++;
            id = next;
        }
        
        answer.push(sum);
    }
    
    const tmp = answer.sort((a, b) => b-a);
    return tmp.length === 1 ? 0 : tmp[0] * tmp[1];
}