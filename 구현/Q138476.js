function solution(k, tangerine) 
{
    // 중복이 제일 적은 애부터 제거
    const map = new Map();
    tangerine.forEach(i => map.set(i, map.get(i) ? Number(map.get(i)) + 1 : 1));
    
    const arr = [...map].sort((a, b) => b[1] - a[1]);
    let cnt = tangerine.length;
    let id = arr.length - 1;
    while(cnt > k)
    {
        const target = arr[id][1];
        if(cnt - target < k)
            break;
        
        cnt -= target;
        arr.pop();
        id--;
    }
    
    return arr.length;
}