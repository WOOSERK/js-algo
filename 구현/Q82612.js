function solution(price, money, count) 
{
    const i = count * (count+1) / 2 * price;
    
    return i > money ? i - money : 0;
}