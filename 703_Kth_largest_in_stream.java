class KthLargest {
    PriorityQueue<Integer> pq=new PriorityQueue<>();  //min heap
    int kt=0;
    public KthLargest(int k, int[] nums) {
        int n=nums.length;
        for(int val:nums){
            if(pq.size()<k){
                pq.offer(val);
            } 
            else if(pq.peek()<val){
                pq.poll();
                pq.offer(val);
            }
            else{
                continue;
            }
        }
        kt=k;
    }
    
    public int add(int val) {
        
        if(pq.size()<(kt)){
            pq.offer(val);
        } 
        else if(pq.peek()<val){
            pq.poll();
            pq.offer(val);
        } 
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 
 That's the key to solving this problem - use a min-heap (min means that the heap will remove/find the smallest element, 
 a max heap is the same thing but for the largest element) and keep the heap at size k. 
 That way, the smallest element in the heap (the one we can access in O(1)O(1)) will always be the kth largest element. 
 This way, when adding a number to the heap with add(), we can do it very quickly in \log(n)log(n) time. 
 If our heap exceeds size k, then we can also remove it very quickly. In the end, the smallest element in the heap will be the answer.
 */
//  Given Solution
// class KthLargest {
//     private static int k;
//     private PriorityQueue<Integer> heap;
    
//     public KthLargest(int k, int[] nums) {
//         this.k = k;
//         heap = new PriorityQueue<>();
        
//         for (int num: nums) {
//             heap.offer(num);
//         }
        
//         while (heap.size() > k) {
//             heap.poll();
//         }
//     }
    
//     public int add(int val) {
//         heap.offer(val);
//         if (heap.size() > k) {
//             heap.poll();
//         }

//         return heap.peek();
//     }
// }
