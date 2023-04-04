function solution(survey, choices) 
{
    const map = new Map();
    map.set('R', 0);
    map.set('T', 0);
    map.set('C', 0);
    map.set('F', 0);
    map.set('J', 0);
    map.set('M', 0);
    map.set('A', 0);
    map.set('N', 0);
    
    survey.forEach((v, id) => {
        const score = choices[id] - 4;
        if(score < 0)
            map.set(v[0], map.get(v[0]) - score);
        else if(score > 0)
            map.set(v[1], map.get(v[1]) + score);
        else
            return;
    });
    
    const answer = [];
    
    const fun = (a, b) => {
        const sa = map.get(a);
        const sb = map.get(b);
        if(sa > sb)
            return a;
        else if(sa < sb)
            return b;
        else
            return a < b ? a : b;
    }
    
    answer.push(fun('R', 'T'));
    answer.push(fun('C', 'F'));
    answer.push(fun('J', 'M'));
    answer.push(fun('A', 'N'));
    
    return answer.join('');
}