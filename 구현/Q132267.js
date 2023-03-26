function solution(a, b, n) 
{
    let answer = 0;
    let empty = n;
    while(empty >= a)
    {
        const coke = b * Math.floor(empty / a);
        empty %= a;
        answer += coke;
        empty += coke;
    }
    
    return answer;
}