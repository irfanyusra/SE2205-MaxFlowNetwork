import java.util.*;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import java.util.Queue;


/**
 * @author Yusra Irfan -- yirfan3 -- 250959680
 *
 */
public class Assignment3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int breadthFirstPathSearch(Graph FN, int s,int d) {
		int parent[] = new int [FN.size()]; 
		int visited[] = new int [FN.size()]; 
	  // Create a visited array and mark all vertices as 0
	        for(int i=0; i<visited.length; i++) 
	            visited[i]=0; 
	  
	        // Create a queue, enqueue f
	        Queue<Integer> queue = new LinkedList<>(); 
	        queue.add(s);
	        parent[s]=-1;
	        
	        while (queue.size()!=0) 
	        { 
	        
	        	int dequeued = queue.remove(); 
	        	for (int v=0; v<visited.length; v++) 
	            { 
	                if (visited[v]==0 ) // and check if the capacity - flow > 0 of the edge 
	                { 
	                    queue.add(v); 
	                    parent[v] = dequeued; 
	                    visited[v] = 1; 
	                } 
	            } 
	        	
	        }
	        	       
	        return  (visited[d]) ; 
	  
	}
		
	public void maximizeFlowNetwork(Graph fN, int s,int t) {
		
		
		  
         while (breadthFirstPathSearch( fN,  s, t)==1) 
        { 
        
        } 
  
    
		
	} 
//	
//	class Node {
//
//		ArrayList<Edge> edges = new ArrayList<>();
//
//	}
//
//	
	
	class Edge {
		
		public int flow , flowCap;
		//Edge reverse;

		public Edge(int u , int v , int flow , int capacity) {
			
			this.flow = flow;
			flowCap = capacity;
		}
	

}
}
