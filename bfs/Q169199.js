class Queue
{
    constructor()
    {
        this.items = {};
        this.front = 0;
        this.rear = 0;
    }
    
    enqueue(item)
    {
        this.items[this.rear++] = item;
    }
    
    dequeue()
    {
        const ret = this.items[this.front];
        delete this.items[this.front++];
        return ret;
    }
    
    isEmpty()
    {
        return this.rear - this.front === 0;
    }
}

function solution(board) 
{
    const visited = Array.from(Array(board.length), () => new Array(board[0].length).fill(-1));
    board = board.map(e => e.split(""));
    
    const d = [[-1, 0], [0, -1], [0, 1], [1, 0]];
    let gr, gc;
    let rr, rc;
    
    for(let i=0; i<board.length; i++)
    {
        for(let j=0; j<board[i].length; j++)
        {
            if(board[i][j] === 'R')
                [rr, rc] = [i, j];
            else if(board[i][j] === 'G')
                [gr, gc] = [i, j];
        }
    }
    
    const queue = new Queue();
    queue.enqueue([rr, rc, 0]);
    visited[rr][rc] = 0;
    while(!queue.isEmpty())
    {
        const tmp = queue.dequeue();
        
        for(let i=0; i<4; i++)
        {
            let [r, c] = tmp;
            while(true)
            {
                const [newR, newC] = [r + d[i][0], c + d[i][1]];
                if(newR < 0 || newR >= board.length)
                    break;
                if(newC < 0 || newC >= board[0].length)
                    break;
                if(board[newR][newC] === 'D')
                    break;
                
                r = newR;
                c = newC;
            }
            
            if(visited[r][c] !== -1)
                continue;
            
            visited[r][c] = visited[tmp[0]][tmp[1]] + 1;
            queue.enqueue([r, c, visited[r][c]]);
        }
    }
    
    return visited[gr][gc];
}