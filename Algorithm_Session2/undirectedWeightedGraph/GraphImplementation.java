package undirectedWeightedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import undirectedWeightedGraph.GraphStructure.Edge;

/**
 * class containing implementation of graph
 * 
 */
public class GraphImplementation implements Graph {

	private List<Integer> pathList;
	LinkedList<Edge> adjacencyList[];
	private int distanceArray[];
	private boolean isVisited[];
//	private List<Integer> shortestPathList;

	/**
	 * method to check if the given graph is connected or not
	 * 
	 * @param Graph
	 *            object
	 * @return true if graph is connected otherwise return false
	 */
	@Override
	public boolean isConnected(GraphStructure graph) {
		pathList = getDepthFirstSearchTraversal(graph);
		if (pathList.size() == graph.getNumberOfVertices()) {
			return true;
		}
		return false;
	}

	/**
	 * method to find list of reachable vertex from a particular vertex
	 * 
	 * @param graphStructure
	 *            object
	 * @param vertex
	 *            for which we have to find reachable vertices
	 */
	@Override
	public List<Integer> getReachableVertices(GraphStructure graph, int vertex) {
		adjacencyList = graph.getAdjacencyList();
		pathList = new ArrayList<Integer>();
		isVisited = new boolean[graph.getNumberOfVertices()];
		traverseRecursively(graph, vertex);
		return pathList;
	}

	

	/**
	 * method to obtain minimum spanning tree whose root is vertex 0
	 * 
	 * @param graph
	 *            structure object
	 */
	@Override
	public int[] getMinimumSpanningTree(GraphStructure graph) {
		distanceArray = new int[graph.getNumberOfVertices()];
		int numberOfVertices = graph.getNumberOfVertices();
		// contain the vertex for MST
		Set<Integer> spanningTreeSet = new HashSet<Integer>();
		// mark the distance array to max value at starting
		Arrays.fill(distanceArray, Integer.MAX_VALUE);
		// set the distance source vertex 0 
		distanceArray[0] = 0;
		adjacencyList = graph.getAdjacencyList();
		List<Edge> list;
		while (spanningTreeSet.size() != numberOfVertices) {
			for (int vertex = 0; vertex < numberOfVertices; vertex++) {
				if (!spanningTreeSet.contains(vertex)) {
					spanningTreeSet.add(vertex);
					list = adjacencyList[vertex];
					for (Edge value : list) {
						int sumOfWeightAndSourceVertexDistanceValue = distanceArray[vertex]
								+ value.getWeight();
						int distanceValueOfDestinationVertex = distanceArray[value
								.getVertex()];
						if (sumOfWeightAndSourceVertexDistanceValue < distanceValueOfDestinationVertex) {
							distanceArray[value.getVertex()] = sumOfWeightAndSourceVertexDistanceValue;
						}
					}
				}
			}
		}
		return distanceArray;
	}

	/**
	 * method to find shortest path between a source and destination using
	 * Dijkstra's algorithm
	 * 
	 * @param source
	 *            vertex
	 * @param destination
	 *            vertex
	 * @return list of vertices making shortest path
	 */
	@Override
	public boolean[] getShortestPath(int source, int destination,GraphStructure graph) {
		
		int numberOfVertices = graph.getNumberOfVertices();
		distanceArray = new int[numberOfVertices];
		isVisited = new boolean[numberOfVertices];
		int parent[] = new int[numberOfVertices];
		
		Arrays.fill(distanceArray, Integer.MAX_VALUE);
		Arrays.fill(isVisited, false);
		
		distanceArray[source] = 0;
		
		for(int index = 0 ; index < numberOfVertices-1;  index++){
			int minVertex = minDistance(distanceArray, isVisited);
			isVisited[minVertex] = true;
			List<Edge> list = graph.getAdjacencyList()[minVertex];
			
			for (Edge v : list) {
				if (isVisited[v.getVertex()] == false
						&& distanceArray[minVertex] != Integer.MAX_VALUE
						&& distanceArray[minVertex] + graph[minkey][column] < distanceArray[column]) {
					{
						distanceArray[column] = distanceArray[minkey]
								+ graph[minkey][column];
						parent[column] = source;
					}
				}
			}
		}
		
		
	}
	
	public int minDistance(int distance[], boolean isVisited[]) {
		int minDistance = Integer.MAX_VALUE;
		int minVertex = 0;
		
		for (int index = 0; index < distance.length; index++) {
			if (isVisited[index] == false && distance[index] < minDistance) {
				minDistance = distance[index];
				minVertex = index;
			}
		}
		return minVertex;
	}
	/**
	 * helper method to find shortest path between two vertices
	 * 
	 * @param graph
	 *            object
	 * @param start
	 *            vertex
	 * @param destination
	 *            vertex
	 */
//	private void calculateShortestDistances(GraphStructure graph,int startVertex, int destinationVertex) {
//		//traverseRecursively(graph, startVertex);
//				if(pathList.contains(destinationVertex)) {
//					distanceArray = new int [graph.getNumberOfVertices()];
//					int numberOfVertices=graph.getNumberOfVertices();
//					Set<Integer> spanningTreeSet = new HashSet<Integer>();
//					Arrays.fill(distanceArray,Integer.MAX_VALUE);
//					distanceArray[startVertex]=0;
//					adjacencyList = graph.getAdjacencyList();
//					List<Edge> list;
//					list = graph.getAdjacencyList()[startVertex];
//					if(startVertex==destinationVertex) {
//						return;
//					} else {
//						for(Edge value : list) {
//							if(! isVisited[value.getVertex()]) {
//								int sumOfWeightAndSourceVertexDistanceValue = distanceArray[startVertex] + value.getWeight();
//								int distanceValueOfDestinationVertex =  distanceArray[value.getVertex()];
//								if( sumOfWeightAndSourceVertexDistanceValue < distanceValueOfDestinationVertex ) {
//									distanceArray[value.getVertex()] = sumOfWeightAndSourceVertexDistanceValue;
//									shortestPathList.add(value.getVertex());
//									calculateShortestDistances(graph,value.getVertex(), distanceValueOfDestinationVertex);
//								} 
//							} 
//						}
//					}
//					
//					/*for(Integer value : spanningTreeSet) {
//						System.out.print(value+" ");
//					}*/
//				} 
//	}

	/**
	 * method traverse the graph in Depth First Order
	 * 
	 * @param Graph
	 *            object as input
	 * @return the pathList calculated
	 */
	public List<Integer> getDepthFirstSearchTraversal(GraphStructure graph) {
		pathList = new ArrayList<Integer>();
		int numberOfVertices = graph.getNumberOfVertices();
		isVisited = new boolean[graph.getNumberOfVertices()];
		adjacencyList = graph.getAdjacencyList();
		traverseRecursively(graph, 0);
		return pathList;
	}

	/**
	 * helper method for getting Depth first traversal of the graph recursively
	 * 
	 * @param graph
	 *            object
	 * @param vertex
	 *            to be traversed
	 */
	private void traverseRecursively(GraphStructure graph, Integer vertex) {
		List<GraphStructure.Edge> list = adjacencyList[vertex];
		pathList.add(vertex);
		isVisited[vertex] = true;
		for (GraphStructure.Edge adjacentVertex : list) {
			if (!isVisited[adjacentVertex.getVertex()]) {
				traverseRecursively(graph, adjacentVertex.getVertex());
			}
		}
	}

}