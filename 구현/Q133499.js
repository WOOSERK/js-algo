function solution(babbling) 
{
    const tmp = ['aya', 'ye', 'woo', 'ma'];
    
    return babbling.reduce((acc, cur) => {
        let ccur = cur;
        let prev = null;
        while(ccur.length > 0)
        {
            const res = tmp.filter(v => ccur.indexOf(v) === 0);
            
            if(res.length === 0 || res[0] === prev)
                break;
            
            ccur = ccur.substr(res[0].length);
            prev = res[0];
        }
        
        if(ccur.length === 0)
            acc++;
        
        return acc;
    }, 0);
}