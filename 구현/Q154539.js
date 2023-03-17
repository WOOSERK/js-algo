function solution(numbers) 
{
    const arr = [];
    const answer = [];
    for(let i=numbers.length-1; i>=0; i--)
    {
        let tmp = -1;
        while(arr.length !== 0)
        {
            const num = arr[arr.length - 1];
            if(numbers[i] < num)
            {
                tmp = num;
                break;
            }
            
            arr.pop();
        }
              
        arr.push(numbers[i]);
        answer.push(tmp);
    }
    
    return answer.reverse();
}