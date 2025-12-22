class MedianFinder {

    PriorityQueue<Integer> smol; 
    PriorityQueue<Integer> large;
    
    public MedianFinder() {
        smol = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smol.add(num);
        large.add(smol.poll());
        if(smol.size() < large.size()){
            smol.add(large.poll());
        }
    }
    
    public double findMedian() {
        if(smol.size() == large.size()){
            return (smol.peek() + large.peek()) / 2.0;
        }
        return smol.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */