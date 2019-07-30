//Time and space complexity are both O(E), where E is the number of outcomes
//Where outcomes means the number of matches, i.e. match results

//DFS answers if there is a path between two nodes.
public class DFS{
	static class ResultOfMatch{
		public String winningTeam;
		public String losingTeam;

		public ResultOfMatch(String winningTeam, String losingTeam){
			this.winningTeam = winningTeam;
			this.losingTeam = losingTeam;
		}
	}

	// Is there a path from team A to team B, where every team in the path has beaten the next team in the path
	//Yes, if B is reachable from A then yes, there is a path for this.
	public static boolean canTeamABeatTeamB(List<ResultOfMatch> matches, String teamA, String teamB){
		//keep track of visited nodes, so as to avoid CYCLES
		Set<String> visited = new HashSet<>();
		//Let's find if B is reachable from A, by using DFS. We can also use BFS.
		// isReachableDFS(graph, A, B, visited)
		return isReachableDFS(buildGraph(matches), teamA, teamB, visited);

	}

	private static Map<String, Set<String>> buildGraph(List<ResultOfMatch> matches){
		//CREATE an empty graph
		Map<String, Set<String>> graph = new HashMap<>();
		//Go through the matches list
		for(ResultOfMatch match : matches){
			//Find the set of team that winningTeam in this iteration has beaten
			Set<String> edges = graph.get(match.winningTeam);
			if(edges == null){
				//if there is no such "set", then make it
				edges = new HashSet<>();
				//and put the set in the graph
				graph.put(match.winningTeam, edges);
			}
			//since we have a losing team now, we add the losing team to this set of losing teams
			edges.add(match.losingTeam);
		}
		return graph;
	}

	//Always check the simplest thing before you go deeper

	private static boolean isReachableDFS(Map<String, Set<String>> graph,
											String curr, String dest,
											Set<String> visited){

		if(curr == dest){
			return true;
		} else if (visited.contains(curr) && graph.get(curr) == null){ 
			//we have already visited curr and curr didn't had any teams beaten by it
			return false;
		}

		visited.add(curr); //visit curr

		for(String team : graph.get(curr)){
			if(isReachableDFS(graph,team,dest,visited)){
				return true;
			}
			//if not reachable, then check the other team that is beaten by curr
		}
		return false;
	}

}