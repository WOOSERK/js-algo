function solution(board) 
{
    const cnts = [0, 0];
    
    for(let i=0; i<board.length; i++)
    {
        for(let j=0; j<board[i].length; j++)
        {
            if(board[i][j] === 'O')
                cnts[0]++;
            else if(board[i][j] === 'X')
                cnts[1]++;
        }
    }
    
    if(Math.abs(cnts[0] - cnts[1]) >= 2)
        return 0;
    
    if(cnts[1] > cnts[0])
        return 0;
    
    const endO = isEnd(board, 'O');
    const endX = isEnd(board, 'X');
    
    if(endO && cnts[0] === cnts[1])
        return 0;
    
    if(endX && cnts[0] > cnts[1])
        return 0;
    
    return 1;
}

function isEnd(board, ch) 
{
    for(let i=0; i<3; i++)
    {
        if(ch === board[i][0] && ch === board[i][1] && ch === board[i][2])
            return true;
        
        if(ch === board[0][i] && ch === board[1][i] && ch === board[2][i])
            return true;
    }
    
    const d1 = ch === board[0][0] && ch === board[1][1] && ch === board[2][2];
    const d2 = ch === board[2][0] && ch === board[1][1] && ch === board[0][2];
    
    return d1 || d2;
}