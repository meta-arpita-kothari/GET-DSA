package undirectedWeightedGraph;

import java.util.LinkedList;

/**
 * class for defining structure of a graph
 * 
 */
public class GraphStructure {

	private int numberOfVertices;
	private LinkedList<Edge> adjacencyList[];
	
	/**
	 * constructor to create edgeList
	 * @param numberOfVertices
	 */
	public GraphStructure (int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		adjacencyList = new LinkedList[numberOfVertices];
		
		for(int i=0;i<numberOfVertices;i++) {
			adjacencyList[i] = new LinkedList<Edge>();
		}
	}
	
	/**
	 * Edge class containing attributes of edge
	 */
	static class Edge {
		
		private int vertex;
		private int weight;
		
		public Edge (int vertex,int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		public int getVertex() {
			return vertex;
		}

		public int getWeight() {
			return weight;
		}
		
		
	}
	/**
	 * method to add edge to undirected graph
	 * @param source
	 * @param destination
	 * @param weight
	 */
	public void addEdgeToGraph(int source, int destination,int weight) {
		Edge edge1 = new Edge(source, weight);
		Edge edge2 = new Edge(destination, weight);
		adjacencyList[source].add(edge2);
		adjacencyList[destination].add(edge1);
	}

	public void printGraph(){

		for(int i =0 ;i< adjacencyList.length; i++){

        	System.out.println("\nAdjacency list of vertex " + i);
			System.out.print("head : "+i);
            for (int j = 0; j < adjacencyList[i].size(); j++) {
                System.out.print(" -> "+adjacencyList[i].get(j).vertex+"("+adjacencyList[i].get(j).weight+")");
            }
            System.out.println();
		}
	}
	public int getNumberOfVertices() {
		return numberOfVertices;
	} 

	public LinkedList<Edge>[] getAdjacencyList() {
		return adjacencyList;
	}
	
	
	
}