/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    const st = [];

    for(let ch of s)
    {
        if(ch === '(' || ch === '[' || ch === '{')
        {
            st.push(ch);
            continue;
        }

        const prev = st.pop();
        if(ch === ')')
        {
            if(prev !== '(')
                return false;
        }
        else if(ch === ']')
        {
            if(prev !== '[')
                return false;
        }
        else
        {
            if(prev !== '{')
                return false;
        }
    }

    return st.length === 0;
};