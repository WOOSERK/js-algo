class Node
{
    constructor(v, priority)
    {
        this.v = v;
        this.priority = priority;
    }
}

class PriorityQueue
{
    constructor()
    {
        this.arr = [];
    }
    
    enqueue(v, priority)
    {
        const node = new Node(v, priority);
        this.arr = [...this.arr, node];
        this.heapifyUp();
    }
    
    heapifyUp()
    {
        let id = this.arr.length - 1;
        const node = this.arr[id];
        
        while(id > 0)
        {
            let parentId = Math.floor((id - 1) / 2);
            let parent = this.arr[parentId];
            
            if(node.priority < parent.priority)
                break;
            
            this.arr[parentId] = node;
            this.arr[id] = parent;
            
            id = parentId;
        }
    }
    
    dequeue() 
    {
        const max = this.arr[0];
        const end = this.arr.pop();
        
        if(this.arr.length > 0)
        {
            this.arr[0] = end;
            this.heapifyDown();
        }
        
        return max;
    }
    
    heapifyDown()
    {
        let id = 0;
        const node = this.arr[id];
        
        while(true)
        {
            let leftChildId = 2*id + 1;
            let rightChildId = 2*id + 2;
            let leftChild = this.arr[leftChildId];
            let rightChild = this.arr[rightChildId];
            let swap = null;            

            if(leftChildId < this.arr.length)
            {
                leftChild = this.arr[leftChildId];
                if(node.priority < leftChild.priority)
                    swap = leftChildId;
            }
            
            if(rightChildId < this.arr.length)
            {
                rightChild = this.arr[rightChildId];
                if((swap === null && node.priority < rightChild.priority)
                  || (swap !== null && rightChild.priority > leftChild.priority))
                    swap = rightChildId;
            }
            
            if(swap === null)
                break;
            
            this.arr[id] = this.arr[swap];
            this.arr[swap] = node;
            id = swap;
        }
    }
    
    peek()
    {
        return this.arr[0];
    }
}

function solution(book_time) 
{
    const pq = new PriorityQueue();
    const book = book_time.map(i => i.map(j => Number(j.split(":").join(""))));
    book.sort((a, b) => a[0] - b[0]);
    
    for(let i=0; i<book.length; i++)
    {
        if(pq.arr.length > 0)
        {
            const tmp = pq.peek();
            let endTime = tmp.v[1] + 10;
            if(endTime % 100 >= 60)
                endTime = Math.floor(endTime / 100) * 100 + 100 + endTime % 10;

            if(book[i][0] >= endTime)
                pq.dequeue();
        }
        
        pq.enqueue(book[i], -book[i][1]);
    }
    
    return pq.arr.length;
}