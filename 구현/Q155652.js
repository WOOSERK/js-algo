function solution(s, skip, index) 
{
    const arr = new Array(26).fill(0);
    skip.split('').forEach(ch => arr[ch.charCodeAt() - 'a'.charCodeAt()]++);
    
    return s.split('').map((ch) => {
        let id = ch.charCodeAt() - 'a'.charCodeAt();
        let tmp = index;
        
        while(tmp > 0)
        {
            id = (id + 1) % 26;
            if(arr[id] === 1)
                continue;
            
            tmp--;
        }
        
        return String.fromCharCode('a'.charCodeAt() + id);      
    }).join('');
}