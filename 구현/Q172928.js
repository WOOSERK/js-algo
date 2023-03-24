function solution(park, routes) 
{
    let [sr, sc] = [0, 0];
    
    for(let i=0; i<park.length; i++)
    {
        for(let j=0; j<park[i].length; j++)
        {
            if(park[i][j] === 'S')
            {
                [sr, sc] = [i, j];
                break;
            }
        }
    }
    
    const d = [[-1, 0], [0, -1], [0, 1], [1, 0]];
    for(let i=0; i<routes.length; i++)
    {
        let [dir, dist] = routes[i].split(' ');
        dist = Number(dist);
        
        switch(dir)
        {
            case 'N':
                dir = 0;
                break;
            case 'W':
                dir = 1;
                break;
            case 'E':
                dir = 2;
                break;
            case 'S':
                dir = 3;
                break;
        }
        
        let [nr, nc] = [sr, sc];
        while(dist > 0)
        {
            nr += d[dir][0];
            if(nr < 0 || nr >= park.length)
                break;
            
            nc += d[dir][1];
            if(nc < 0 || nc >= park[0].length)
                break;
            
            if(park[nr][nc] === 'X')
                break;
            
            dist--;
        }
        
        if(dist !== 0)
            continue;
        
        sr = nr;
        sc = nc;
    }
    
    return [sr, sc];
}