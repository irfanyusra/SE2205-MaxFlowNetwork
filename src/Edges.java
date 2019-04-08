
public interface Edges<E> {
	public int flowCapacity(); //maximum flow capacity

	public int flow(); //current flow

	public void setFlow(int newFlow); //to set the current flow 
}
