package dataStructure;

public class Edge implements edge_data{
	 private String   id="";
     private int src;
     private int dest;
     private double weight;
     private String info;
     
	

	public Edge(int src, int dest, double weight) {
		super();
		this.src = src;
		this.dest = dest;
		this.weight = weight;
		this.info = src+","+dest+","+weight+",";
		
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
		return 0;
	}

	@Override
	public void setTag(int t) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return src+","+dest+","+weight+","+info ;
	}

}
