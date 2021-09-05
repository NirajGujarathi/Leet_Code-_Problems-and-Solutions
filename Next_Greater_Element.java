/*
Java | Map+Stack | O(N+M)

Conclusions:

We can find next greater element using Stack
Since, all the elements in array are unique, we can use Map to answer the queries in amortized O(1) time.

  Steps:
Create a Stack st and a Map m
for each element in nums2 in reverse order:
find next greater and store it in m
respond to nums1 queries using m
C: O(N+M) | O(N)
*/


class Solution {
    public int[] nextGreaterElement(int[] query, int[] input) {
        int n = input.length;
        
        Map<Integer,Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        
        nextGreater.put(input[n-1],-1);
        stack.push(input[n-1]);
        
        for(int i=n-2;i>=0;i--) {
            while(stack.size()>0 && stack.peek() < input[i]) {
                stack.pop();
            }
            nextGreater.put(input[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(input[i]);
        }
        
        int m = query.length;
        int[] result =  new int[m];
        
        for(int i=0;i<m;i++) {
            result[i] = nextGreater.get(query[i]);
        }
        
        return result;
    }
}
