class PriorityQueue
{
    constructor()
    {
        this.items = [];
    }
        
    enqueue(item)
    {
        this.items.push(item);
        this.heapifyUp();
    }
    
    heapifyUp()
    {
        let id = this.items.length - 1;
        const node = this.items[id];
        
        while(id > 0)
        {
            const parentId = Math.floor((id-1) / 2);
            const parent = this.items[parentId];
            
            if(node < parent)
                break;
            
            this.items[parentId] = node;
            this.items[id] = parent;
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
                
                if(node < leftChild)
                    swap = leftChildId;
            }
            
            if(rightChildId < this.items.length)
            {
                rightChild = this.items[rightChildId];
                
                if(
                    (swap === null && node < rightChild) ||
                    (swap !== null && leftChild < rightChild))
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

function solution(n, k, enemy) 
{
    let answer = 0;
    const heap = new PriorityQueue();

    for(; answer<enemy.length; answer++)
    {
        const next = enemy[answer];
        n -= next;
        heap.enqueue(next);
        
        while(n < 0 && k > 0)
        {
            const tmp = heap.dequeue();
            n += tmp;
            k--;
        }
        
        if(n < 0 && k === 0)
            break;
    }
    
    return answer;
}