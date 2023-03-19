class Node
{
    constructor(item, priority)
    {
        this.item = item;
        this.priority = priority;
    }
}

class PriorityQueue
{
    constructor()
    {
        this.items = [];
    }
    
    enqueue(item, priority)
    {
        const node = new Node(item, priority);
        this.items.push(node);
        this.heapifyUp();
    }
    
    heapifyUp()
    {
        let id = this.items.length - 1;
        const node = this.items[id];
        
        while(id > 0)
        {
            let parentId = Math.floor((id - 1) / 2);
            let parent = this.items[parentId];
            
            if(node.priority <= parent.priority)
                break;
            
            this.items[id] = parent;
            this.items[parentId] = node;
            id = parentId;
        }
    }
    
    dequeue()
    {
        const ret = this.items[0];
        const node = this.items.pop();
        
        if(this.items.length > 0)
        {
            this.items[0] = node;
            this.heapifyDown();
        }
        
        return ret;
    }
    
    heapifyDown()
    {
        let id = 0;
        const node = this.items[id];
        
        while(true)
        {
            let leftChildId = 2*id + 1;
            let rightChildId = 2*id + 2;
            let leftChild = null;
            let rightChild = null;
            let swap = null;
            
            if(leftChildId < this.items.length)
            {
                leftChild = this.items[leftChildId];
                
                if(node.priority < leftChild.priority)
                    swap = leftChildId;
            }
            
            if(rightChildId < this.items.length)
            {
                rightChild = this.items[rightChildId];
                
                if(
                    (swap === null && node.priority < rightChild.priority) ||
                    (swap !== null && leftChild.priority < rightChild.priority))
                    swap = rightChildId;
            }
            
            if(swap === null)
                break;
            
            this.items[id] = this.items[swap];
            this.items[swap] = node;
            id = swap;
        }
    }
    
    length()
    {
        return this.items.length;
    }
}

function solution(k, m, score) 
{
    let answer = 0;
    const pq = new PriorityQueue();
    score.forEach(i => pq.enqueue(i, i));
    
    while(pq.length() >= m)
    {
        let last = null;
        let i = m;
        while(i > 0)
        {
            last = pq.dequeue();
            i--;
        }
        
        answer += last.item * m;
    }
    
    return answer;
}