function solution(ingredient) 
{
    let st = [];
    let answer = 0;
    for(let i=0; i<ingredient.length; i++)
    {
        const cur = ingredient[i];
        const next = cur % 3 + 1;
        
        if(st.length > 0)
        {
            const prev = st[st.length - 1];
            if(prev[1] === cur)
            {
                if(cur === 1)
                {
                    answer++;
                    st.pop();
                    st.pop();
                    st.pop();
                }
                else
                    st.push([cur, next]);
            }
            else if(cur === 1)
                st.push([cur, next]);
            else
                st = [];
        }
        else if(cur === 1)
            st.push([cur, next]);
    }
        
    return answer;
}