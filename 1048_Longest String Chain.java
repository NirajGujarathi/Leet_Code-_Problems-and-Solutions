// similar to LIS problem where instead of dp array we are storing into hashmap

//  O(nlogn) sorting 

//  TC : O( n* l*l) n words times length of each word and generating its predecessor
// space = O(n) for hashmap 

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)-> (a.length() - b.length()));
//      hashmap stores longest predecessor length upto that string 
        Map<String,Integer> hm = new HashMap<>();
        int ans=1;
        for(String word : words){
            int prede_length=0;
            for(int i=0;i<word.length();i++){      // O(l)
                
                //O(l)
                String prede= word.substring(0,i)+word.substring(i+1);
                
                prede_length = Math.max(prede_length, hm.getOrDefault(prede,0)+1);
                
            }
            hm.put(word, prede_length);
            ans = Math.max(ans, prede_length);
        }
        return ans;
    }
}

