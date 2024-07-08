class Solution {
    public int findTheWinner(int n, int k) {
     	Queue<Integer> q= new LinkedList<>();
		for(int i=1;i<=n;i++){
		    q.add(i);
		}
		int i=k;

		while(q.size()!=1){

		    i=k;
		    while(i!=1){
		        int a= q.poll();
		        q.add(a);
		        i--;

		}
     	q.remove();

		}

		return q.poll();
   
    }
}