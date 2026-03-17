class Node implements Comparable<Node>{
    Integer key,val;
    public Node(Integer key,Integer val){
        this.key = key;
        this.val = val;
    }
    
    public int compareTo(Node node){
        Integer x1 = this.val,x2 = node.val;
        return -x1.compareTo(x2);
    }
}

class Solution {
    public  int[] topKFrequent(int[] nums, int k){
        int ans[] = new int[k] , idex=0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int ele : nums){
            int f =  hm.getOrDefault(ele , 0);
            hm.put(ele , f + 1);
        }
        for(int key : hm.keySet()){
            int f = hm.get(key);
            Node node = new Node(key,f);
            pq.offer(node);
        }
        while(idex < k){
            ans[idex++] = pq.poll().key;
        }
        return ans ;
    }
}