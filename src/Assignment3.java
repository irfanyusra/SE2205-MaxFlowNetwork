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
		int parent[] = new int [FN.numVertices()]; 
		int visited[] = new int [FN.numVertices()]; 
		// Create a visited array and mark all vertices as 0
		for(int i=0; i<visited.length; i++) 
			visited[i]=0; 

		// Create a queue, enqueue f
		Queue<Vertex> queue = new LinkedList<>(); 
		queue.add(FN.getVertex(s));
		parent[s]=-1;
		//  visited[s]=1;

		while (queue.size()!=0) 
		{ 

			Vertex dequeued = queue.remove(); 
			for (int v=0; v<visited.length; v++) 
			{ 
				if (visited[v]==0  && FN.getEdge(dequeued, FN.getVertex(v)).flow() > FN.getEdge(dequeued, FN.getVertex(v)).flowCapacity()) 
				{ 
					queue.add(FN.getVertex(v)); 
					parent[v] = dequeued.getLabel(); 
					visited[v] = 1; 
				} 
			} 

		}

		if (visited[d]==1)
			return 1;
		else
			return 0; 

	}

	public void maximizeFlowNetwork(Graph fN, int s,int t) {

		int maximumFlow= 0; //no flow 

		//int v,u;
		while (breadthFirstPathSearch( fN,  s, t)==1) 
		{ 

		} 



	} 



}

