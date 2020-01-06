package algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.JOptionPane;

import dataStructure.*;
import gui.Gui;
import utils.Point3D;

/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author
 *
 */


public class Graph_Algo implements graph_algorithms{

	private  int size;//number of vertexes
	private  Queue<Integer> q;
	public  int dist[], pred[], color[], partition[];
	private  final int WHITE=1, GRAY=2,  BLACK=3, NIL = -1;
	private  graph g=new DGraph();
	private  int numComps, source;
	private  int components[];


	public Graph_Algo(){}
	public Graph_Algo(graph g) {
		init(g);
	}
	@Override
	public void init(graph g) {
		this.g=g;
		dist=new int[g.nodeSize()];
		pred=new int[g.nodeSize()];

		for(int i=0;i<g.nodeSize();i++){
			dist[i]=Integer.MAX_VALUE;
			pred[i]=NIL;
		}



	}

	public graph getGraph(){
		return  this.g;
	}
	@Override
	public graph copy() {
		DGraph g_=(DGraph)this.g;
		DGraph other= (DGraph) g_.copy();
		return other;
	}

	@Override
	public void init(String file_name) {
		this.g=new DGraph();
		File f=new File(file_name);
		try {
			Scanner in=new Scanner(f);


			Node node = null;
			while (in.hasNextLine()){
				String s=in.nextLine();

				if(!s.equals("")){
					if(!s.contains("(")){
						String str[]=s.split(",");
						Point3D location=new Point3D(Double.parseDouble(str[1]),
								Double.parseDouble(str[2]),Double.parseDouble(str[3]));
						int key=Integer.parseInt(str[0]);
						double weight=Double.parseDouble(str[4]);
						node=new Node(location,weight);
						node.setKey(key);


					}
					else{
						String str[]=s.split(",");
						int src=Integer.parseInt(str[0].substring(1));
						int dest=Integer.parseInt(str[1].substring(0));

						double weight=Double.parseDouble(str[2].substring(0, str[2].length()-1));
						Edge e=new Edge(src, dest, weight);
						node.addEdge(e);

					}
				}
				else{
					this.g.addNode(node);
				}

			}

			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save(String file_name) {
		File file=new File(file_name);
		PrintWriter pw;
		try {
			pw=new PrintWriter(file);
			pw.println(g.toString());
			pw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}

	@Override
	public boolean isConnected() {
		DGraph graph=(DGraph) this.g;
		Iterator<node_data> it=graph.iterator();
		while (it.hasNext()){
			if(!isConnected(it.next())){
				return false;
			}
			setTag0();
		}
		return true;
	}

	public boolean isConnected(node_data node){
		node.setTag(1);
		System.out.println(g.nodeSize());
		if(isConnceted(node,0)==g.nodeSize()-1)
			return true;
		return false;

	}

	private int  isConnceted(node_data node,int count){
		DGraph graph=(DGraph) g;
		Node V=(Node)node;

		Iterator<edge_data> it=V.iterator();

		while (it.hasNext()) {

			Edge e = (Edge) it.next();
			Node nextNode = (Node) g.getNode(e.getDest());
			System.out.println(nextNode);
			if(nextNode==null)
				continue;
			if(nextNode.getTag()==0){
				nextNode.setTag(1);
				count= isConnceted(nextNode,count+1);
			}
			else{
				continue;
			}
		}
		return count;

	}

	private  void setTag0(){
		DGraph graph=(DGraph) g;
		Iterator<node_data> it=graph.iterator();
		while (it.hasNext()){
			it.next().setTag(0);
		}
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		//	source=src;
		System.out.println(g.getNode(dest).getWeight());
		PriorityQueue<Integer> q=new PriorityQueue<>();
		g.getNode(src).setWeight(0);
		q.add(src);
		while (!q.isEmpty()){
			Node U =(Node)g.getNode(q.poll());
			for(edge_data e: U.getEdgeList()){
				int V=g.getNode(e.getDest()).getKey();
				if(g.getNode(V).getTag()==0){

					if(U.getWeight()+e.getWeight()<g.getNode(V).getWeight()){

						g.getNode(V).setWeight(U.getWeight()+e.getWeight());
						pred[V]= U.getKey();
						q.add(V);
						//g.getNode(V).setWeight(1);
					}



				}
				//	g.getNode(U.getKey()).setTag(1);

				//	q.remove(U.getKey());
			}
		}
		DGraph g_=(DGraph) g;
		double x=g.getNode(dest).getWeight();
		g_.updatNodeWeight();
		return x ;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		int d=dest;
		shortestPathDist(src, dest);
		ArrayList<node_data> list=new ArrayList<>();
		while (src!=dest){
			try{

				//	list.add(0,g.getNode(dest));
				dest=pred[dest];
				list.add(0,g.getNode(dest));

			}catch(Exception e){
				System.out.println("the path not exist");
				break;
			}

		}
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i).getKey()+"-->");
		}
		System.out.println(d);

		return list;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {

		DGraph g_=new DGraph();
		DGraph poiner=(DGraph)this.g;

		for(int i=0;i<targets.size();i++){
			Node n=(Node)poiner.getNode(targets.get(i));
			g_.addNode(n.copy());
		}

		Graph_Algo ga_=new Graph_Algo();
		ga_.init(g_);
		if(!ga_.isConnected())
			return null;


		return KruskalAlgorithm(g_);
	}
	private ArrayList<node_data> KruskalAlgorithm(DGraph g_){


		ArrayList<edge_data> edgeList=new ArrayList<>();

		Iterator<node_data> it=g_.iterator();
		while(it.hasNext()){
			Node n=(Node)it.next();
			Iterator<edge_data> it2=n.iterator();
			while(it2.hasNext()){
				Edge e=(Edge)it2.next();

				for(int i=0;i<edgeList.size();i++){
					if(e.getWeight()<edgeList.get(i).getWeight()){
						edgeList.add(e);
					}
				}

				if(edgeList.size()==0){
					edgeList.add( e);
				}
			}
		}
		ArrayList<node_data> list=new ArrayList<>();
		while(edgeList.size()>0){
			if((!list.contains(g_.getNode(edgeList.get(0).getSrc())) ) && (!list.contains(g_.getNode(edgeList.get(0).getSrc())))){
				if(!list.contains(g_.getNode(edgeList.get(0).getSrc()))){
					list.add(g_.getNode(edgeList.get(0).getSrc()));
					edgeList.remove(0);
				}
				else{
					list.add(g_.getNode(edgeList.get(0).getDest()));
					edgeList.remove(0);
				}

			}
		}

		return list ;

	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public static void main(String[] args){
		File f=new File("C:\\Users\\смеоеп\\Desktop\\New folder (3)\\a.txt");

		Graph_Algo ga=new Graph_Algo();
		// DGraph g=new DGraph();
		ga.init(f.getPath());
	}

}
