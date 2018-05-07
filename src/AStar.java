import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

// A class containing the implementation of A* algoritm, I made a mistake and implemented the A* instead of BFS
// but you told me to keep it like this and it's ok
public class AStar {
    private PriorityQueue<NodeAStar> Open; //A Qeueue that represents the open list which automatically sorts the Nodes
    private static HeuristicComparator comparator; //The comparison made between Nodes to sort them with the best Heuristic score first

    public AStar(NodeAStar StartNode) {
        comparator = new HeuristicComparator();
        this.Open = new PriorityQueue(comparator);
        StartNode.CalculateHeuristic();
        this.Open.add(StartNode);
    }

    // Runs the A* algoritm and counts the time it take to run
    public void run(String solutionName) {
        int counter = 0;
        double startTime = (double)System.nanoTime();

        while(!this.Open.isEmpty()) {
            NodeAStar Current = Open.poll();
            Current.Expand();
            PrintStream Printer = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            ++counter;
            if (Current.isSolution()) {
                BoardWriter.WriteSolution(Current, solutionName);
                break;
            }

            ArrayList<NodeAStar> children = Current.getChildren();

            for(NodeAStar Successor: children) {

                int Score = Current.getgScore() + 1;
                if (!this.Open.contains(Successor)) {
                    this.Open.add(Successor);
                    Successor.CalculateHeuristic();
                }

                Successor.setgScore(Score);
            }
        }

        System.out.println(((double)System.nanoTime() - startTime) / 1.0E9D);
    }

}
