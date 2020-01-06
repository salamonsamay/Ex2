package dataStructure;

import java.util.*;

import algorithms.Graph_Algo;
import gui.Gui;
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
	/**
	 * deep copy of the graph
	 * @return
	 */
	public graph copy(){
		DGraph other=new DGraph();
		for(Integer i : nodeList.keySet()){
			Node node=(Node)nodeList.get(i);
			other.nodeList.put(i,node.copy());
		}
		other.edgeSize=this.edgeSize;
		return other;
	}
	/**
	 * add node to the graph
	 */
	public void addNode(node_data n) {
		nodeList.put(n.getKey(), (Node) n);

		edgeSize+=((Node) n).getEdgeList().size();
	}

	/**
	 * get source and destintion 
     *and craete edge which represents the connection between 
     *the nodes whose key is src and dest
	 */
	public void connect(int src, int dest, double w) {
		Node n=((Node) nodeList.get(src));
		n.addEdge(new Edge(src, dest, w));

		edgeSize++;

	}


	/**
	 * This method return a pointer (shallow copy) 
	 * for thecollection representing all the nodes in the graph.
	 */
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		return nodeList.values();
	}

    /**
     * This method return a pointer (shallow copy) 
     * for thecollection representing all the nodes in the graph
     */
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		Node n=(Node) nodeList.get(node_id);

		return n.getEdgeList();
	}
	/**
	 *Updates the weight of the node after we change it to find a short route
	 */
    public void updatNodeWeight(){
    	Iterator<node_data> it=iterator();
    	while(it.hasNext()){
    		Node n=(Node)it.next();
    		n.setWeight(Double.MAX_VALUE);
    	}
    }
	/**
	 * removes the node by key
	 */
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub

		return nodeList.remove(key);
	}

	/**
	 * get src and dest
	 * remove the edge 
	 */
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		Node n=(Node) nodeList.get(src);
		return n.removeEdge(dest);
	}

	/**
	 * return the node size of the graph
	 */
	public int nodeSize() {
		// TODO Auto-generated method stub
		return this.nodeList.size();
	}

	/**
	 * return the edge size of the graph
	 */
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
    /**
     * retunn string which represents the graph
     */
	public String toString(){
		String elements="";
		for(node_data nodeElement : nodeList.values()){
			elements+=nodeElement.toString()+"\n";
		}

		return elements;
	}
	/**
	 * node iterator 
	 * @return
	 */
	public Iterator<node_data> iterator(){
		return nodeList.values().iterator();
	}
	public static void main(String[] args){
		DGraph d=new DGraph();
		node_data n0=new Node(new Point3D(60,0,6));
		node_data n1=new Node(new Point3D(70,98,7));
		node_data n2=new Node(new Point3D(-84,550,7));
		node_data n3=new Node(new Point3D(-321,103,1));
		node_data n4=new Node(new Point3D(-573,123,1));
		node_data n5=new Node(new Point3D(72,413,1));
		node_data n6=new Node(new Point3D(-60,-100,1));
		//	System.out.println(n0);
		d.addNode(n0);
		d.addNode(n1);
		d.addNode(n2);
		d.addNode(n3);
		d.addNode(n4);
		d.addNode(n5);
		d.addNode(n6);
		d.connect(0, 1, 5);
		d.connect(0, 2, 1);
		d.connect(2, 0, 1);
		d.connect(2, 1, 6);
		d.connect(3, 2, 1);
		d.connect(1, 3, 2);
		
         
		Graph_Algo ga=new Graph_Algo();
		ga.init(d);
	
		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(0);
	
		
		
		
		ArrayList<node_data> list_=(ArrayList<node_data>) ga.TSP(list);

	/*	
		for(int i=0;i<list_.size();i++){
			System.out.println("---"+list.get(i));
		}*/
   //     Gui gui=new Gui();
   //     gui.init(ga);
    
     //  System.out.println(ga.isConnected());
     

         
          

	}
}
