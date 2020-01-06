package dataStructure;

public class Edge implements edge_data{

	private int src;
	private int dest;
	private double weight;
	private String info;
	private int tag;



	public Edge(int src, int dest, double weight) {

		this.src = src;
		this.dest = dest;
		this.weight = weight;
		this.info = src+","+dest+","+weight+",";

	}
	/**
	 * copy constracor
	 * @param e
	 */
	public Edge(edge_data e){
		this(e.getSrc(),e.getDest(),e.getWeight());
	}
	/**
	 * copy the object
	 * @return copy of this
	 */
	public edge_data copy(){
		return new Edge(src, dest, weight);
	}
	/**
	 * get source
	 */
	public int getSrc() {
		// TODO Auto-generated method stub
		return src;
	}

	/**
	 * get Destintion
	 */
	public int getDest() {
		// TODO Auto-generated method stub
		return dest;
	}

	/**
	 * get weight
	 */
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}
	/**
	 * get info
	 */
	public String getInfo() {
		// TODO Auto-generated method stub
		return info;
	}

	/**
	 * set info
	 */
	public void setInfo(String s) {
		// TODO Auto-generated method stub
		this.info=s;

	}

	/**
	 * get tag
	 */
	public int getTag() {
		// TODO Auto-generated method stub
		return tag;
	}

	/**
	 * set tag
	 */
	public void setTag(int t) {
		// TODO Auto-generated method stub
		this.tag=t;

	}
	/**
	 *  toString function
	 */
	public String toString() {
		return getSrc()+","+getDest()+","+getWeight();
	}

}
