import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] var0) {
        BoardReader var3 = new BoardReader();
        //Read from user
        System.out.print("Which algoritm do you want to use: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        System.out.print("Which input do you want to use: ");
        String string1 = scanner.next() + ".txt";
        System.out.println("How do you want to name the solution file: ");
        String solution = scanner.next() + ".txt";
        int[][] var4 = BoardReader.ReadFile(string1);
        int Rows = BoardReader.getRows();
        int Cols = BoardReader.getColumns();
        if (string.equals("depth")){
            NodeDepthFirst nodeDepthFirst = new NodeDepthFirst(var4, Rows, Cols, null, 0, 0, 0, 0);
            DepthFirstSearch depthFirstSearch = new DepthFirstSearch(nodeDepthFirst);
            depthFirstSearch.compute(solution);
        }
        else if (string.equals("best")){
            NodeAStar nodeAStar = new NodeAStar(var4, Rows, Cols, (NodeAStar)null, 0, 0, 0, 0);
            AStar aStar = new AStar(nodeAStar);
            aStar.run(solution);
        }
        else {
            System.out.println("No such algortithm found");
        }


    }
}