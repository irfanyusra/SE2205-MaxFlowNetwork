import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yusra Irfan -- yirfan3 -- 250959680
 * @author Phillip Hung Truong -- htruon -- 250957227
 */
public class Assignment3 {

	public int breadthFirstPathSearch(Graph <Integer,Integer> FN, int s, int d) {
		int visited[] = new int[FN.numVertices()];
		// Create a visited array and mark all vertices as 0
		for (int i = 0; i < visited.length; i++)
			visited[i] = 0;

		// Create a queue, enqueue f
		Queue<Vertex<Integer>> queue = new LinkedList<>();
		queue.add(FN.getVertex(s)); //add the first node
		FN.getVertex(s).setPredecessor(-1); //set the parent to -1 which means it has no parent
		visited[s] = 1;

		while (!queue.isEmpty()) { //size of q is not 0

			Vertex<Integer> dequeued = queue.remove(); //dequeue the node
			for (int v = 0; v < visited.length; v++) {
				Edges <Integer> edge = FN.getEdge(dequeued, FN.getVertex(v)); 
				if (visited[v] == 0 && edge.flow() < edge.flowCapacity()) { //checking if its full or not 
					queue.add(FN.getVertex(v)); //adding the vertex to the list
					FN.getVertex(s).setPredecessor(dequeued.getLabel()); //setting the parent
					visited[v] = 1;
				} //end if
			} //end for
		}// end while 

		if (visited[d] == 1) //if all visited 
			return 1;
		else
			return 0;
	} //end function 

	public void maximizeFlowNetwork(Graph<Integer, Integer> fN, int s, int t) {

		// if there are only two nodes
		if (s == t) 
			return;

		int maximumFlow = 0; // initially no flow

		Graph<Integer, Integer> residualGraph = fN; //copy graph including flow capacity 

		// assuming flow is initially zero
		
		
		Vertex<Integer> vertexV, vertexU;

		while (breadthFirstPathSearch(fN, s, t) == 1) { //if a path exists 
			int flow = Integer.MAX_VALUE; // we want the minimum, so initially set it to the max number possible.
			vertexV = fN.getVertex(t); //end vertex
			Edges <Integer> uvEdge ;
			while (vertexV != fN.getVertex(s)) { //loop till its the start vertex
				vertexU = vertexV.getPredecessor(); //saves v's parent
				uvEdge =  residualGraph.getEdge(vertexU, vertexV); //saves the edge 
				flow = minimum(flow, uvEdge.flowCapacity());
				vertexV = vertexU; //v's parent 
			} //end while 

			vertexV = fN.getVertex(t); //end vertex
			while (vertexV != fN.getVertex(s)) { //loop till its the start vertex
				vertexU = vertexV.getPredecessor(); //saves v's parent
				uvEdge =  residualGraph.getEdge(vertexU, vertexV);				
				uvEdge.setFlow(uvEdge.flow() + flow);// forward
				uvEdge.setFlow(uvEdge.flow() - flow);// reverse
				vertexV = vertexU; //v's parent 
			} //end while
			maximumFlow += flow; //increases the maximum flow
		} //end while 

		System.out.println(maximumFlow);
	} //end function

	private int minimum(int flow, int capacity) {
		//return the minimum value
		if (flow < capacity)
			return flow;
		else
			return capacity;

	} //end function
} // end class
