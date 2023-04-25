class SmallestInfiniteSet {
    TreeSet<Integer> set;
    int current;

    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        current = 1;
    }
    
    public int popSmallest() {
        if(!set.isEmpty())
            return set.pollFirst();

        return current++;
    }
    
    public void addBack(int num) {
        if(num < current)
            set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */