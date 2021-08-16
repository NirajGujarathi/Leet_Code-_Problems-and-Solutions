// topological sort method 
class Solution 
{
    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        int stat[]=new int[V];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            for(Integer n:adj.get(i)){
                stat[n]++; //if node found increase its indegree 
            }
        }
        for(int i=0;i<V;i++){
            if(stat[i]==0) q.offer(i);
        }
        int cnt=0;
        while(!q.isEmpty()){
            
                int node=q.poll();
                cnt++;
                
                for(Integer nebr:adj.get(node)){
                    stat[nebr]--;
                    if(stat[nebr]==0){
                        q.offer(nebr);
                    }
                   
            
            }
        }
        if(cnt==V) return false;
        else return true;
    }
}
