package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;

import utils.Point3D;

public class Node implements node_data{
	private int key=0;
	private Point3D location;
	private double weight;
	private String info;
	private int tag;
	private ArrayList<Edge> edgeList=new ArrayList<>();
	private static int counter=0;


	public Node(Point3D location, double weight,String info) {
		super();
		this.key=counter++;
		this.location = location;
		this.weight = weight;
		this.info =info;
	}

	public void addEdge(Edge e){
		edgeList.add(e);

	}
	public void removeEdge(Edge e){
		edgeList.remove(e);
	}
	public Node(Point3D location, double weight){
		this.key=counter++;
		this.location = location;
		this.weight = weight;
		info="";
	}

	@Override
	public int getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public Point3D getLocation() {
		// TODO Auto-generated method stub
		return location;
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
		this.tag=tag;

	}

	public static void main(String[] args){
		Node n=new Node(new Point3D(2,4,2), 123, "");
		System.out.println(n.key);
		Node n2=new Node(new Point3D(2,4,2), 123, "");
		System.out.println(n2.key);
		Node n3=new Node(new Point3D(2,4,2), 123, "");
		System.out.println(n3.key);

	}

	@Override
	public String toString() {
		return key+","+location+","+weight+","+info ;
	}

}
