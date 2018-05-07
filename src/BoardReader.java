import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// A class that reads from the input file and initiates the beginning state of the board
public class BoardReader {
    private static int Rows;
    private static int Columns;

    public BoardReader() {
    }

    public static int[][] ReadFile(String var0) {
        File var1 = new File(var0);

        try {
            Scanner var4 = new Scanner(var1);
            Rows = var4.nextInt();
            Columns = var4.nextInt();
            int[][] var5 = new int[Rows][Columns];

            for(int var2 = 0; var2 < Rows; ++var2) {
                for(int var3 = 0; var3 < Columns; ++var3) {
                    if (var4.hasNextInt()) {
                        var5[var2][var3] = var4.nextInt();
                    } else {
                        System.err.println("File format is wrong");
                    }
                }
            }

            return var5;
        } catch (FileNotFoundException var6) {
            var6.printStackTrace();
            return (int[][])null;
        }
    }

    public static int getRows() {
        return Rows;
    }

    public static int getColumns() {
        return Columns;
    }
}
