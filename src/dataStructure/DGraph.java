package dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import utils.Point3D;

public class DGraph implements graph{

	HashMap<Integer,node_data> nodeList=new HashMap<>();
	HashMap<String, Edge> edgeList=new HashMap<>();
	HashMap<Integer, ArrayList<edge_data>>  road=new HashMap<>();
     
    
	/**
	 * O(n)
	 * @param key
	 * @return
	 */
	public node_data getNode(int key) {
		return nodeList.get(key);
	}

	/**
	 * 
	 * @param src
	 * @param dest
	 * @return
	 */
	public edge_data getEdge(int src, int dest) {
		return edgeList.get(src+","+dest);
	}

	@Override
	public void addNode(node_data n) {
		nodeList.put(n.getKey(), (Node) n);
	}

	@Override
	public void connect(int src, int dest, double w) {
		Edge edge=new Edge(src, dest, w);
		ArrayList<edge_data> list;
		edgeList.put(edge.getSrc()+","+edge.getDest(), edge);
		if((road.get(src)==null)){
			list=new ArrayList<>();
			list.add(edge);
			road.put(src, list);
			return;
		}
		list= road.get(src);
		list.add(edge);


	}

	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		return (Collection<node_data>) nodeList;
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		return road.get(node_id);
	}

	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return this.edgeList.remove(src);
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return this.nodeList.size();
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return this.edgeList.size();
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void print(){
		String s="";
		for (Integer name: nodeList.keySet()){
			String key = name.toString();
			String value = nodeList.get(name).toString();  
			System.out.println(key + " " + value);  
		} 
		

	}

	public static void main(String[] args){
		DGraph d=new DGraph();
		node_data n=new Node(new Point3D(2,32,9), 12, "");
		node_data n2=new NodeEdge(n);
		node_data n3=new Node(new Point3D(4,22,3), 42, "");
		node_data n4=new NodeEdge(n2);
		d.addNode(n2);

		d.addNode(n4);
		d.connect(2, 43, 3);
		d.print();
		System.out.println();

	}
}
