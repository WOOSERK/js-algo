function solution(keymap, targets) 
{
    let answer = [];
    
    let arr = new Array(26).fill(-1);
    
    for(let i=0; i<keymap.length; i++)
    {
        for(let j=0; j<keymap[i].length; j++)
        {
            const id = keymap[i][j].charCodeAt() - 'A'.charCodeAt();
            
            if(arr[id] === -1 || j + 1 < arr[id])
                arr[id] = j + 1;
        }
    }
            
    for(let i=0; i<targets.length; i++)
    {
        let cnt = 0;
            
        for(let j=0; j<targets[i].length; j++)
        {
            const id = targets[i][j].charCodeAt() - 'A'.charCodeAt();
            
            if(arr[id] === -1)
            {
                answer.push(-1);
                break;
            }
            
            cnt += arr[id];
            if(j === targets[i].length - 1)
                answer.push(cnt);
        }
    }
    
    return answer;
}