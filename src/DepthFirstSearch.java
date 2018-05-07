import java.util.ArrayList;
import java.util.Stack;

// A class that implements the DFS algorithm using a stack to add all the Unexplored nodes
public class DepthFirstSearch {

    private Stack<NodeDepthFirst> stack;

    public DepthFirstSearch(NodeDepthFirst StartNode){
        stack = new Stack<NodeDepthFirst>();
        stack.push(StartNode);
        StartNode.setVisited(true);
    }

    //The method that runs the DFS algorithm using the initialized board state that we got from
    //the BoardReader class
    public void compute(String solutionName){

        //time count
        double startTime = System.nanoTime();
        while (!stack.isEmpty())
        {
            //Get Current Node
            NodeDepthFirst current = stack.pop();

            //Expand the current node based on the possible moves
            current.Expand();

            //check if it is a solution
            if (current.isSolution()){
                BoardWriter.WriteSolution(current, solutionName);
                break;
            }
            //Add the nodes in the stack
            //then the algorithm takes the 1st node and goes in, but new nodes are added in the stack so it is Depth First
            ArrayList<NodeDepthFirst> neighbours= current.getChildren();
            for (int i = 0; i < neighbours.size(); i++) {
                NodeDepthFirst n=neighbours.get(i);
                if(n!=null && !n.isVisited())
                {
                    stack.push(n);
                    n.setVisited(true);
                }
            }

        }

        System.out.println((System.nanoTime() - startTime) / 1000000000);
    }
}
