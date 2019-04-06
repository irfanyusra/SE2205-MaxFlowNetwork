import java.util.*;

import java.util.Queue;


/**
 * @author Yusra Irfan -- yirfan3 -- 250959680
 * @author Phillip Hung Truong -- htruon -- 250957227
 */
public class Assignment3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int breadthFirstPathSearch(Graph FN, int s,int d) {
	int visited[] = new int [FN.numVertices()]; 
		// Create a visited array and mark all vertices as 0
		for(int i=0; i<visited.length; i++) 
			visited[i]=0; 

		// Create a queue, enqueue f
		Queue<Vertex> queue = new LinkedList<>(); 
		queue.add(FN.getVertex(s));
		FN.getVertex(s).setPredecessor(-1);
		visited[s]=1;

		while (queue.size()!=0) 
		{ 

			Vertex dequeued = queue.remove(); 
			for (int v=0; v<visited.length; v++) 
			{ 
				if (visited[v]==0  && FN.getEdge(dequeued, FN.getVertex(v)).flow() > FN.getEdge(dequeued, FN.getVertex(v)).flowCapacity()) 
				{ 
					queue.add(FN.getVertex(v)); 
					//parent[v] = dequeued.getLabel(); 
					FN.getVertex(s).setPredecessor(dequeued.getLabel());
					visited[v] = 1; 
				} 
			} 

		}

		if (visited[d]==1)
			return 1;
		else
			return 0; 

	}

	
	public void maximizeFlowNetwork(Graph<Integer,Integer>fN, int s,int t) { 

		int maximumFlow= 0; //no flow 

		
		//int vertexU=0;	//iterator vertices to loop over the matrix
		//int vertexV =0;

		Graph <Integer, Integer> residualGraph = fN;
		//assuming flow is iinitially zero 
		
		
		
		 Vertex <Integer> v,u;
		
			
		
		while (breadthFirstPathSearch( fN,  s, t)==1) 
		{ 
			int bottleneckFlow = Integer.MAX_VALUE;		//we want the bottleneck (minimum), so initially set it to the largest number possible. Loop updates value if it's smaller
			v = fN.getVertex(t); 
			
			while (v!=fN.getVertex(s)) {
				u=v.getPredecessor();
				bottleneckFlow = minimum(bottleneckFlow, residualGraph.getEdge(u, v).flowCapacity());
				v=v.getPredecessor();
			}
				
			v = fN.getVertex(t); 
			while (v!=fN.getVertex(s)) {
				u=v.getPredecessor();
				residualGraph.getEdge(u, v).setFlow(residualGraph.getEdge(u, v).flow()+bottleneckFlow);//forward 	
				residualGraph.getEdge(u, v).setFlow(residualGraph.getEdge(u, v).flow()-bottleneckFlow);//reverse
				v=v.getPredecessor();
			}
			maximumFlow=+ bottleneckFlow;
	} 
	

		 
		 
		System.out.println(maximumFlow);
}

	private int minimum(int bottleneckFlow, int capacity) {
		// TODO Auto-generated method stub
		
		if (bottleneckFlow<capacity)
			return bottleneckFlow;
		else return capacity;
		
	}
}

