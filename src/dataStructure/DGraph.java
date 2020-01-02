package dataStructure;

import java.util.*;

import algorithms.Graph_Algo;
//import com.sun.corba.se.impl.orbutil.graph.Graph;
import utils.Point3D;

public class DGraph implements graph{

	public HashMap<Integer,node_data> nodeList=new HashMap<>();
	int edgeSize=0;


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
		return (edge_data) ((Node) nodeList.get(src)).getEdge(dest);
	}
	public graph copy(){
		DGraph other=new DGraph();
		for(Integer i : nodeList.keySet()){
			Node node=(Node)nodeList.get(i);
			other.nodeList.put(i,node.copy());
		}
		return other;
	}
	@Override
	public void addNode(node_data n) {
		nodeList.put(n.getKey(), (Node) n);

		edgeSize+=((Node) n).getEdgeList().size();
	}

	@Override
	public void connect(int src, int dest, double w) {
		Node n=((Node) nodeList.get(src));
		n.addEdge(new Edge(src, dest, w));

		edgeSize++;

	}

	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		return nodeList.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		Node n=(Node) nodeList.get(node_id);

		return n.getEdgeList();
	}

	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub

		return nodeList.remove(key);
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		Node n=(Node) nodeList.get(src);
		return n.removeEdge(dest);
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return this.nodeList.size();
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return edgeSize;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}
	public ArrayList<node_data> getV(int i){
		Node n=(Node)getNode(i);
		ArrayList<node_data> node_data=new ArrayList<>();
		Iterator<edge_data> it=n.iterator();
		while (it.hasNext()){
			Edge e=(Edge) it.next();
			node_data.add(this.nodeList.get(e.getDest()));
		}
		return node_data;
	}

	public String toString(){
		String elements="";
		for(node_data nodeElement : nodeList.values()){
			elements+=nodeElement.toString()+"\n";
		}

		return elements;
	}
	public Iterator<node_data> iterator(){
		return nodeList.values().iterator();
	}
	public static void main(String[] args){
		DGraph d=new DGraph();
		node_data n0=new Node(new Point3D(6,0,6), 1000000);
		node_data n1=new Node(new Point3D(7,0,7), 1000000);
		node_data n2=new Node(new Point3D(4,5,7), 1000000);
		node_data n3=new Node(new Point3D(1,1,1), 1000000);
		node_data n4=new Node(new Point3D(1,1,1), 1000000);
		node_data n5=new Node(new Point3D(1,1,1), 1000000);
		node_data n6=new Node(new Point3D(1,1,1), 1000000);
		//	System.out.println(n0);
		d.addNode(n0);
		d.addNode(n1);
		d.addNode(n2);
		d.addNode(n3);
		d.addNode(n4);
		d.addNode(n5);
		d.addNode(n6);
		d.connect(0, 2, 1);
		d.connect(1, 2, 9);
		d.connect(1, 0, 6);
		d.connect(2, 1, 6);
		d.connect(2, 3, 3);
		d.connect(3, 1, 5);
		d.connect(0,4,4);

		d.connect(5,6,1);
		d.connect(1,5,1);
		d.connect(6,3,2);


		//	System.out.println(d.getV());
		Graph_Algo ga=new Graph_Algo();
		ga.init(d);

     
		//	System.out.println(ga.isConnected());
//
//		System.out.println(	ga.shortestPathDist(1,2));
//		ga.shortestPath(1,2);
//		System.out.println(d);
		String path="C:\\Users\\смеоеп\\Desktop\\New folder (3)\\a.txt";
		System.out.println(ga.getGraph().toString());
		ga.save(path);
		System.out.println(ga.toString());
		Graph_Algo ga2=new Graph_Algo();
		ga2.init(path);
		System.out.println("--------");
		System.out.println(ga2.getGraph().toString());



	}
}
