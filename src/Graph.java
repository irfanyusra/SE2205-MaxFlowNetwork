


public interface Graph<E, V> {

	public int numVertices();
	public Iterable<Vertex<V>> vertices();
	public int numEdges();
	public Iterable<Edges<E>> edges();
	public Edges<E> getEdge(Vertex<V> u,Vertex<V> v);
	public Iterable<Vertex<V>> endVertices(Edges<E> e);
	public Vertex<V> opposite(Vertex<V> v, Edges<E> e);
	public int outDegree(Vertex<V> v);
	public int inDegree(Vertex<V> v);
	public Iterable<Edges<E>> outgoingEdges(Vertex<V> v);
	public Iterable<Edges<E>> incomingEdges(Vertex<V> v);
	public void insertVertex(Vertex<V> v);
	public void insertEdge(Vertex<V> u, Vertex<V> v, E x);
	public void removeVertex(Vertex<V> v);
	public void removeEdge(Edges<E> e);
	public Vertex<V> getVertex(int label);
}
