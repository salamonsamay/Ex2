package dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import utils.Point3D;

public class Node implements node_data{
	private int key=0;
	private Point3D location;
	private double weight=Double.MAX_VALUE;
	private String info;
	private int tag;
	private HashMap<Integer, edge_data> edgeList=new HashMap<>();
	private static int counter=0;

    
	public Node(){}
	public Node(Point3D location, double weight,String info) {
		this.key=counter++;
		this.location = location;
		this.weight = weight;
		this.info =info;
	}
	
	public Node(Point3D location){
		this.key=counter++;
		this.location = location;
	}
	public Node(Point3D location, double weight){
		this.key=counter++;
		this.location = location;
		this.weight = weight;
		info="";
	}

	public void addEdge(Edge e){

		edgeList.put(e.getDest(), e);


	}
	public boolean isconnect(node_data n){
		Node node=(Node)n;
		if(this.edgeList.get(n.getKey())!=null)
			return true;
		return false;
	}
 

     
	public edge_data removeEdge(Edge e){
		return edgeList.remove(e);
	}
	public edge_data removeEdge(int dest){
		return edgeList.remove(dest);
	}
	

	@Override
	public int getKey() {
		// TODO Auto-generated method stub
		return key;
	}
	
	public void setKey(int key){
		this.key=key;
	}

	@Override
	public Point3D getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
    public edge_data getEdge(int dest){
		return edgeList.get(dest);
	}
	@Override
	public void setLocation(Point3D p) {
		this.location=p;

	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public void setWeight(double w) {
		// TODO Auto-generated method stub
		this.weight=w;

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return info;
	}

	@Override
	public void setInfo(String s) {
		// TODO Auto-generated method stub
		info=s;

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



	public Collection<edge_data> getEdgeList() {
		return edgeList.values();
	}

	public void setEdgeList(HashMap<Integer, edge_data> edgeList) {
		this.edgeList = edgeList;
	}
    
	public node_data copy(){
		Node other=new Node(new Point3D(getLocation()), getWeight());
		other.setTag(getTag());
		other.setInfo(getInfo());
		other.setKey(getKey());
		
		for(Integer i:edgeList.keySet()){
			Edge e=new Edge(edgeList.get(i));
			other.edgeList.put(i,e);
		}
		return other;
	}
	public static void main(String[] args){
	   Node n=new Node(new Point3D(2,22,3),8.5);
	   Node n2=new Node(new Point3D(2,22,3),8.5);
	   Node n3=new Node(new Point3D(2,22,3),8.5);
	   Edge e=new Edge(0,3,3);
	   Edge e2=new Edge(2,6,1);
	   Edge e3=new Edge(3,5,9);
	   n.addEdge(e);
	   n.addEdge(e2);
		System.out.println(n.isconnect(n3));

		Iterator<edge_data> list=n.iterator();

		while (list.hasNext()){
			System.out.println(list.next());
		}
	}
    public Iterator<edge_data> iterator(){
	   return edgeList.values().iterator();
	}

	@Override
	public String toString() {
		String data=getKey()+","+getLocation()+","+getWeight();
		String value="";
		//		s+=key+","+location+","+weight+",";

		for(edge_data edge:edgeList.values()){
			value+="("+edgeList.get(edge.getDest())+")"+"\n";

		}
		return data+"\n"+value ;
	}

}
