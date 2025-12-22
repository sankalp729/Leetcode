class MedianFinder {
    
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;
    
    public MedianFinder() {
        smallHeap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        largeHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // step 1 : blindly add to small :  
        smallHeap.add(num);
        
        // step 2 : move to large :
        largeHeap.add(smallHeap.poll());

        //step 3 : move back :
        if(largeHeap.size() > smallHeap.size()){
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallHeap.size() == largeHeap.size()){
            return (smallHeap.peek() + largeHeap.peek()) / 2.0;
        }else if(smallHeap.size() > largeHeap.size()){
            return smallHeap.peek();
        }else{
            return largeHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */