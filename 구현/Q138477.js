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
            let parentId = Math.floor((id-1) / 2);
            let parent = this.items[parentId];
            
            if(node.priority >= parent.priority)
                break;
            
            this.items[id] = parent;
            this.items[parentId] = node;
            id = parentId;
        }
    }
    
    dequeue()
    {
        const ret = this.items[0];
        const end = this.items.pop();
        
        if(this.items.length > 0)
        {
            this.items[0] = end;
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
                if(node.priority > leftChild.priority)
                    swap = leftChildId;
            }
            
            if(rightChildId < this.items.length)
            {
                rightChild = this.items[rightChildId];
                
                if(
                (swap === null && node.priority > rightChild.priority) ||
                (swap !== null && rightChild.priority < leftChild.priority))
                    swap = rightChildId;
            }
            
            if(swap === null)
                break;
            
            this.items[id] = this.items[swap];
            this.items[swap] = node;
            id = swap;
        }
    }
    
    peek()
    {
        return this.items[0].item;
    }
    
    length() 
    {
        return this.items.length;
    }
}

function solution(k, score) 
{
    const pq = new PriorityQueue();
    const answer = [];
    
    for(let i=0; i<score.length; i++)
    {
        if(pq.length() < k)
            pq.enqueue(score[i], score[i]);
        else if(score[i] > pq.peek())
        {
            pq.dequeue();
            pq.enqueue(score[i], score[i]);
        }
        
        answer.push(pq.peek());
    }
    
    return answer;
}