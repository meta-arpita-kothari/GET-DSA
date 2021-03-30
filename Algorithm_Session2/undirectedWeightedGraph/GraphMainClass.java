package undirectedWeightedGraph;


/**
 * class containing main method
 * 
 */
public class GraphMainClass {
	
	public static void main(String args[]) {
		
		GraphStructure graph = new GraphStructure(7);
		
		graph.addEdgeToGraph(0,1,1);
		graph.addEdgeToGraph(0,2,1);
		graph.addEdgeToGraph(0,3,5);
		graph.addEdgeToGraph(0,4,2);
		graph.addEdgeToGraph(1,3,1);
		graph.addEdgeToGraph(1,4,3);
		graph.addEdgeToGraph(3,4,2);
		graph.addEdgeToGraph(2,5,5);
		graph.addEdgeToGraph(2,6,7);
		graph.addEdgeToGraph(5,6,8);
		//print graph
		System.out.println("Graph in edge list structure:  ");
		graph.printGraph();
		
		GraphImplementation obj = new GraphImplementation();
		System.out.println("Graph methods performed below: ");
		
		// function call to check if graph is connected or not
		System.out.println("Connected : "+obj.isConnected(graph));
		System.out.println("-------------------------------------------------- ");
		
		//function call to find the reachable vertex from 0
		System.out.println("Reachable vertex from 0: ");
		for(int value : obj.getReachableVertices(graph, 0)) {
			System.out.print(value+" ");
		}
		System.out.println("\n-------------------------------------------------- ");
		
		// function call to find the shortest path from vertex 0 to 3
//		System.out.println("\nShortest path from 0 to 3:");
//		boolean[] res = obj.getShortestPath(0, 3, graph);
//		for(int i =0 ;i<graph.getNumberOfVertices();i++) {
//			if(res[i])
//				System.out.print(i+" ");
//		}
//		System.out.println("\n-------------------------------------------------- ");
//		
		// function call to find the shortest path from vertex 0 to 3
		System.out.println("\nMinimum Spanning Tree:");
		System.out.println("\nvertex\tdistance from source");
		int[] distanceArray = obj.getMinimumSpanningTree(graph);
		for (int i=0;i<graph.getNumberOfVertices();i++) {
			System.out.println(i+"\t"+distanceArray[i]);
		}
		
		
	}
	
}