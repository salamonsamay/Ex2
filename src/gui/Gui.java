package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.Edge;
import dataStructure.Node;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;
import utils.StdDraw;
/**
 * The class represents a graphical interface of a graph
 * Who knows how to do things like
 * Displays the graph
 * Enable the following functions
 * isconnected
 * TSP
 * save
 * init
 * save
 * shortPathdis
 * shortPathRoad
 * All drawings are done by the attached stdraw class
 * @author смеоеп
 *
 */
public class Gui  {
	DGraph g=new DGraph();



	public Gui(){

		//MainDraw();
	}
	/**
	 *  A constructor that gets a graph and draws it
	 * @param graph
	 */
	public Gui(graph graph){

		this.g=(DGraph)graph;
		StdDraw.setCanvasSize(700,700);
		StdDraw.setXscale(-600,600);
		StdDraw.setYscale(-600,600);



		MainDraw();
	}
	/**
	 * In this function we will set the size of the window
	 * The boundaries of the coordinates
	 * We will go through all the points of the graph and draw them
	 */
	public void MainDraw(){
		StdDraw.setCanvasSize(700,700);
		StdDraw.setXscale(-600,600);
		StdDraw.setYscale(-600,600);
		Iterator<node_data> it=this.g.iterator();
		while(it.hasNext()){
			Node node=(Node)it.next();
			Point3D src=node.getLocation();
			StdDraw.setPenColor(Color.black);
			StdDraw.filledCircle(src.x(), src.y(), 9);
			StdDraw.text(src.x(), src.y() + 20, "" + node.getKey());
			Iterator<edge_data> it2=node.iterator();

			while(it2.hasNext()){
				Edge edge=(Edge)it2.next();

				Point3D dest=this.g.getNode(edge.getDest()).getLocation();

				StdDraw.setPenColor(Color.red);
				StdDraw.setPenRadius(0.007);
				StdDraw.line(src.x(), src.y(), dest.ix(), dest.y());

				StdDraw.setPenColor(Color.blue);
				StdDraw.text((src.x()*0.2 +dest.x()*0.8), (src.y()*0.2+dest.y()*0.8)+10, "" + edge.getWeight());

				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.filledCircle((src.x()*0.1 +dest.x()*0.9), (src.y()*0.1 +dest.y()*0.9),5);


			}

		}
		StdDraw.createMenuBar();

	}

	/**
	 * init the graph
	 * @param ga 
	 */

	public void init(Graph_Algo ga){
		StdDraw.ga=ga;
		this.g=(DGraph) ga.getGraph();

		StdDraw.setCanvasSize(700,700);
		StdDraw.setXscale(-600,600);
		StdDraw.setYscale(-600,600);

		MainDraw();

	}

	public static void main(String[] args){
		DGraph d=new DGraph();
		node_data n0=new Node(new Point3D(-600,-600,6), 12);
		node_data n1=new Node(new Point3D(600,600,7), 43);
		node_data n2=new Node(new Point3D(198,23,7), 10000);
		node_data n3=new Node(new Point3D(56,49,1), 1000000);
		node_data n4=new Node(new Point3D(29,43,1), 100000);
		node_data n5=new Node(new Point3D(121,488,1), 1000000);
		node_data n6=new Node(new Point3D(421,231,1), 1000000);
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

		//	Gui2 gui=new Gui2();

		Graph_Algo ga=new Graph_Algo();
		//	   ga.init(d);
		//  ga.save("C:\\Users\\смеоеп\\Desktop\\New folder (3)\\a.txt");
		//	ga.init("C:\\Users\\смеоеп\\Desktop\\New folder (3)\\a.txt");
		ga.init(d);
		Gui gui2=new Gui();
		gui2.init(ga);
	}

}
