import java.util.Comparator;

//A Class made to compare the Heuristic values of 2 nodes and determine which one has the lowest value
//in order to be used in the PriorityQueue in the AStar Class
public class HeuristicComparator implements Comparator<NodeAStar> {
    public HeuristicComparator() {
    }

    public int compare(NodeAStar var1, NodeAStar var2) {
        if (var1.getHeuristic() > var2.getHeuristic()) {
            return 1;
        } else {
            return var1.getHeuristic() < var2.getHeuristic() ? -1 : 0;
        }
    }
}