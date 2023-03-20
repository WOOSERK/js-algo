function solution(arrayA, arrayB) 
{
    const gcd = (a, b) => {
        if(b === 0)
            return a;

        const r = a % b;
        return gcd(b, r);
    };
    
    const rem1 = arrayA.reduce((acc, cur) => gcd(cur, acc));
    const rem2 = arrayB.reduce((acc, cur) => gcd(cur, acc));
    
    const check1 = arrayA.some(i => i % rem2 === 0);    
    const check2 = arrayB.some(i => i % rem1 === 0);
    
    if(!check1 && !check2)
        return rem1 > rem2 ? rem1 : rem2;
    else if(!check1)
        return rem2;
    else if(!check2)
        return rem1;
    
    return 0;
}