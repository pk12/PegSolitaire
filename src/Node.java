import java.util.ArrayList;

//A parent class so that we are able to separate the Node needed for AStar and the Node needed for DepthFirstSearch
public class Node {
    public static int Xmax;
    public static int Ymax;
    protected int[][] LastMove; //Saves the move made to get from the parent node to this one
    protected int counter; //Counts the number of Pegs on the board
    protected Node Parent;
    protected boolean Visited = false;
    protected int[][] Board; //The Board state of this Node

    public Node(int[][] Board, int Xmax, int Ymax, Node Parent, int OldI, int OldJ, int NewI, int NewJ) {
        this.Board = Board;
        this.Parent = Parent;
        this.LastMove = new int[1][4];
        //sets the move made to get to this node from the parent node
        this.LastMove[0][0] = OldI;
        this.LastMove[0][1] = OldJ;
        this.LastMove[0][2] = NewI;
        this.LastMove[0][3] = NewJ;
        this.counter = 0;
        this.Xmax = Xmax;
        this.Ymax = Ymax;
    }

    //Getters And Setters
    public int[][] getLastMove() {
        return LastMove;
    }

    public int getCounter() {
        return counter;
    }


    public Node getParent() {
        return Parent;
    }

    public boolean isVisited() {
        return Visited;
    }

    public void setVisited(boolean visited) {
        Visited = visited;
    }

    public int[][] getBoard() {
        return Board;
    }
}
