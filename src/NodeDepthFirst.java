import java.util.ArrayList;
import java.util.Arrays;

public class NodeDepthFirst extends Node {
    private ArrayList<NodeDepthFirst> children;

    public NodeDepthFirst(int[][] BoardState, int X, int Y, Node Parent, int OldI, int OldJ, int NewI, int NewJ) {
        super(BoardState, X,Y,Parent,OldI,OldJ,NewI,NewJ);
        this.children = new ArrayList<NodeDepthFirst>();

    }


    //Calculates children nodes and add them to the arraylist
    public void Expand() {
        for (int i = 0; i < Xmax; i++) {
            for (int j = 0; j < Ymax; j++) {
                if(Board[i][j] == 1){
                    counter++;

                    //checks the top
                    if (i > 1) {
                        if (Board[i - 1][j] == 1 && Board[i - 2][j] == 2) {
                            //Create a copy of the Board and make a new node with it
                            int[][] Clone1 = new int[Xmax][Ymax];
                            Clone1 = Arrays.stream(Board).map(x -> x.clone()).toArray(int[][]::new);
                            Clone1[i][j] = 2;
                            Clone1[i - 1][j] = 2;
                            Clone1[i - 2][j] = 1;
                            children.add(new NodeDepthFirst(Clone1, Xmax, Ymax, this, i, j, i - 2, j));
                        }
                    }
                    //checks the Left
                    if (j > 1) {
                        if (Board[i][j - 1] == 1 && Board[i][j - 2] == 2) {
                            //Create a copy of the Board and make a new node with it
                            int[][] Clone2 = new int[Xmax][Ymax];
                            Clone2 = Arrays.stream(Board).map(x -> x.clone()).toArray(int[][]::new);
                            Clone2[i][j] = 2;
                            Clone2[i][j - 1] = 2;
                            Clone2[i][j - 2] = 1;
                            children.add(new NodeDepthFirst(Clone2, Xmax, Ymax, this, i, j, i, j-2));
                        }
                    }
                    //checks the Right
                    if (j < Ymax - 2) {
                        if (Board[i][j + 1] == 1 && Board[i][j + 2] == 2) {
                            //Create a copy of the Board and make a new node with it
                            int[][] Clone3 = new int[Xmax][Ymax];
                            Clone3 = Arrays.stream(Board).map(x -> x.clone()).toArray(int[][]::new);
                            Clone3[i][j] = 2;
                            Clone3[i][j + 1] = 2;
                            Clone3[i][j + 2] = 1;
                            children.add(new NodeDepthFirst(Clone3, Xmax, Ymax, this, i, j, i, j+2));
                        }
                    }
                    //Checks the Bottom
                    if (i < Xmax - 2) {
                        if (Board[i + 1][j] == 1 && Board[i + 2][j] == 2) {
                            //Create a copy of the Board and make a new node with it
                            int[][] Clone4 = new int[Xmax][Ymax];
                            Clone4 = Arrays.stream(Board).map(x -> x.clone()).toArray(int[][]::new);
                            Clone4[i][j] = 2;
                            Clone4[i + 1][j] = 2;
                            Clone4[i + 2][j] = 1;
                            children.add(new NodeDepthFirst(Clone4, Xmax, Ymax, this, i, j, i+2, j));
                        }
                    }
                }


            }

        }
    }


    public boolean isSolution(){
        if (this.counter == 1)
            return true;
        else
            return false;
    }



    //Getters Setters


    public ArrayList<NodeDepthFirst> getChildren() {
        return children;
    }


}