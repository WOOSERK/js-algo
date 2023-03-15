function solution(wallpaper) 
{
    let left = wallpaper[0].length;
    let right = 0;
    let up = wallpaper.length;
    let down = 0;
    
    for(let i=0; i<wallpaper.length; i++) 
    {
        for(let j=0; j<wallpaper[i].length; j++) 
        {
            if(wallpaper[i][j] === '.')
                continue;
            
            if(j < left)
                left = j;
            
            if(j >= right)
                right = j + 1;
            
            if(i < up)
                up = i;
            
            if(i >= down)
                down = i + 1;
        }
    }
    
    const answer = [up, left, down, right];
    
    return answer;
}