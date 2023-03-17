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
        this.items[this.rear++] = item
    }
    
    dequeue()
    {
        const ret = this.items[this.front];
        delete this.items[this.front++];
        return ret;
    }
    
    peek()
    {
        return this.items[rear];
    }
    
    isEmpty()
    {
        return this.rear - this.front === 0;
    }
}

function solution(maps) 
{
    const answer = [];
    const d = [[-1, 0], [0, -1], [0, 1], [1, 0]];
    maps = maps.map(i => i.split(""));
    const visited = Array.from(Array(maps.length), () => new Array(maps[0].length).fill(false));
    
    let gId = 0;
    for(let i=0; i<maps.length; i++)
    {
        for(let j=0; j<maps[i].length; j++)
        {
            if(visited[i][j] || maps[i][j] === 'X')
                continue;
            
            const queue = new Queue();
            queue.enqueue([i, j]);
            visited[i][j] = true;
            answer[gId] = Number(maps[i][j]);
            
            while(!queue.isEmpty())
            {
                const tmp = queue.dequeue();
                
                for(let k=0; k<4; k++)
                {
                    const newR = tmp[0] + d[k][0];
                    if(newR < 0 || newR >= maps.length)
                        continue;
                    
                    const newC = tmp[1] + d[k][1];
                    if(newC < 0 || newC >= maps[0].length)
                        continue;
                    
                    if(visited[newR][newC] || maps[newR][newC] === 'X')
                        continue;
                    
                    answer[gId] += Number(maps[newR][newC]);
                    visited[newR][newC] = true;
                    queue.enqueue([newR, newC]);
                }
            }
            
            gId++;
        }
    }
    
    return answer.length === 0 ? [-1] : answer.sort((a, b) => a-b);
}