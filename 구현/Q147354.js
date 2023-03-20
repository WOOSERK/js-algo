function solution(data, col, row_begin, row_end) 
{
    data.sort((a, b) => a[col-1] === b[col-1] ? b[0] - a[0] : a[col-1] - b[col-1]);
    const S_i = data.reduce((acc, cur, id) => {
        cur.forEach(item => acc[id] += item % (id + 1));
        return acc;
    }, new Array(data.length).fill(0));
    
    let answer = S_i[row_begin-1];
    for(let i=row_begin; i<row_end; i++)
        answer ^= S_i[i];
    
    return answer;
}