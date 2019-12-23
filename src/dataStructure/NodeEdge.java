package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;

import utils.Point3D;

public class NodeEdge extends Node{

	private node_data node;
	private ArrayList<edge_data> edges=new ArrayList<>();
    
	public NodeEdge(node_data n){
		super(n.getLocation(), n.getWeight(), n.getInfo());
		this.node=n;
	}
	public void add(Edge e){
		edges.add(e);
	  
	}
	public node_data getNode() {
		return node;
	}
	public void setNode(node_data node) {
		this.node = node;
	}
	public ArrayList<edge_data> getEdges() {
		return edges;
	}
	public void setEdges(ArrayList<edge_data> edges) {
		this.edges = edges;
	}
	
	public static void main(String[] args){
	    Node n=new Node(new Point3D(1,2,3), 22, "");
	    Node n2=new Node(new Point3D(2,2,3), 42,"");
	    Node n3=new Node(new Point3D(3,2,3), 5, "");
	    Node n4=new Node(new Point3D(4,2,3), 34,"");
		HashMap<Node,Node> g=new HashMap<>();
		g.put(n, n2);
		g.put(n3, n4);
		g.put(n2, n);
		System.out.println(g);
		NodeEdge e=new NodeEdge(n4);
	
		
	}
	

}
