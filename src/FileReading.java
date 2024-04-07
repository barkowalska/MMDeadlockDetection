import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReading {
    String file;
    public FileReading(String file)
    {
        this.file=file;

    }
    public ArrayList<Node> parse() throws FileNotFoundException {
        File input= new File(this.file);
        Scanner scanner= new Scanner(input);
        ArrayList<Node> nodes= new ArrayList<Node>();
        while (scanner.hasNextLine())
        {
            int u= scanner.nextInt();
            int v= scanner.nextInt();

            nodes.add(new Node(u,v));

        }
        return nodes;

    }
}
