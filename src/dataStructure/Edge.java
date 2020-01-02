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

	public Edge(edge_data e){
		this(e.getSrc(),e.getDest(),e.getWeight());
	}

	public edge_data copy(){
		return new Edge(src, dest, weight);
	}
	@Override
	public int getSrc() {
		// TODO Auto-generated method stub
		return src;
	}

	@Override
	public int getDest() {
		// TODO Auto-generated method stub
		return dest;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return info;
	}

	@Override
	public void setInfo(String s) {
		// TODO Auto-generated method stub
		this.info=s;

	}

	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return tag;
	}

	@Override
	public void setTag(int t) {
		// TODO Auto-generated method stub
		this.tag=t;

	}

	public String toString() {
		return getSrc()+","+getDest()+","+getWeight();
	}

}
