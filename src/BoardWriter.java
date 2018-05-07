import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

//A class that writes the result in the Solution.txt file
public class BoardWriter {
    public BoardWriter() {
    }

    public static void WriteSolution(Node node, String solutionName) {
        try {
            FileOutputStream var1 = new FileOutputStream(solutionName);
            OutputStreamWriter var2 = new OutputStreamWriter(var1);
            BufferedWriter writer = new BufferedWriter(var2);

            for(int var4 = 0; var4 < Node.Xmax; ++var4) {
                for(int var5 = 0; var5 < Node.Ymax; ++var5) {
                    writer.write(node.getBoard()[var4][var5] + " ");
                }

                writer.write("\n");
            }

            //Get all the nodes from the last to the first and add them in a stack
            //so that the order is from the first node to the last
            Stack<Node> Ancestors = new Stack<Node>();
            while (node.getParent() != null){
                Ancestors.push(node);
                node = node.getParent();
            }

            writer.write(Ancestors.size() + "\n");

            //Pop each Node from the stack and write the move made
            while(!Ancestors.isEmpty()) {
                node = Ancestors.pop();
                int[][] LastMove = node.getLastMove();
                writer.write(++LastMove[0][0] + " " + ++LastMove[0][1] + " " + ++LastMove[0][2] + " " + ++LastMove[0][3] + "\n");
            }

            writer.close();
            var2.close();
            var1.close();
            System.out.println("Solution Wrote");
        } catch (FileNotFoundException var6) {
            var6.printStackTrace();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }
}
