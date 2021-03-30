package undirectedWeightedGraph;

import java.util.List;
import java.util.Set;

/**
 * Interface containing the methods for graph implementation
 * 
 */
public interface Graph {

	public boolean isConnected(GraphStructure graph);
	public List<Integer> getReachableVertices(GraphStructure graph,int vertex);
	public int[] getMinimumSpanningTree(GraphStructure graphs);
	public boolean[] getShortestPath(int source, int destination,GraphStructure graph);
	
}