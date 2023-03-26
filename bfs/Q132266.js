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

function solution(n, roads, sources, destination) 
{
    const list = Array.from(new Array(n+1), () => []);
    
    const queue = new Queue();
    roads.forEach(v => {
        const s = v[0];
        const e = v[1];
        list[s].push(e);
        list[e].push(s);
    });
    
    const d = new Array(n+1).fill(1000000);
    d[destination] = 0;
    queue.enqueue([destination, 0]);
    while(!queue.isEmpty())
    {
        const tmp = queue.dequeue();
        const dist = tmp[1];

        list[tmp[0]].forEach(v => {
           if(dist + 1 < d[v])
           {
               d[v] = dist + 1;
               queue.enqueue([v, dist + 1]);
           }
        });
    }
    
    return sources.map(v => d[v] === 1000000 ? -1 : d[v]);
}