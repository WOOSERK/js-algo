function solution(maps) 
{
    const visited = Array.from(Array(2), () => Array.from(Array(maps.length), () => new Array(maps[0].length).fill(-1)));
    
    const dr = [-1, 0, 0, 1];
    const dc = [0, -1, 1, 0];
    
    const queue = [];
    
    let sR, sC, eR, eC;
    for(let i=0; i<maps.length; i++)
    {
        for(let j=0; j<maps[i].length; j++)
        {
            if(maps[i][j] === 'S')
            {
                sR = i;
                sC = j;
            }
            else if(maps[i][j] === 'E')
            {
                eR = i;
                eC = j;
            }
        }
    }
    
    visited[0][sR][sC] = 0;
    queue.push({r: sR, c: sC, lever: 0});
    
    while(queue.length > 0) 
    {
        const tmp = queue.shift();
        for(let i=0; i<4; i++)
        {
            const newR = tmp.r + dr[i];
            if(newR < 0 || newR >= maps.length)
                continue;
            
            const newC = tmp.c + dc[i];
            if(newC < 0 || newC >= maps[0].length)
                continue;
            
            if(visited[tmp.lever][newR][newC] !== -1 || maps[newR][newC] === 'X')
                continue;
            
            const isLever = (tmp.lever || maps[newR][newC] === 'L') ? 1 : 0;
            visited[isLever][newR][newC] = visited[tmp.lever][tmp.r][tmp.c] + 1;
            queue.push({r: newR, c: newC, lever: isLever});
        }
    }
    
    return visited[1][eR][eC];
}