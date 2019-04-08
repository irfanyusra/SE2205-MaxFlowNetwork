
public interface Vertex<V> {

	public int getLabel(); 

	public Vertex<V> getPredecessor(); //basically get parent, got it from the slides

	public void setPredecessor(int i); //basically set parent, got it from the slides
}
