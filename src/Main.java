import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {


        FileReading fileReading= new FileReading("C:\\Users\\jkowa\\IdeaProjects\\assigment_5\\src\\example.txt");
        ArrayList<Node> nodes = null;
        try {
            nodes=  fileReading.parse();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Scanner scanner= new Scanner(System.in);
        System.out.println("Nodes number: " + Integer.toString(nodes.size()));
        for(Node node: nodes)
            System.out.println("public key of blocked: "+ node.getU() + " | private key: " + node.getV() );

        while (true)
        {
            System.out.println("Enter blocked node (enter -1 to quit): ");
            int blocked=scanner.nextInt();

            if(blocked==-1)break;
            System.out.println("Enter blocking node");
            int blocking=scanner.nextInt();
            System.out.println("Before: ");
            System.out.println("public key of blocked: "+ nodes.get(blocked).getU() + " | private key: " + nodes.get(blocked).getV() );
            System.out.println("public key of blocking: "+ nodes.get(blocking).getU() + " | private key: " + nodes.get(blocking).getV() );

            nodes.get(blocking).addBlocked(blocked);
            nodes.get(blocked).addBlocking(blocking,nodes.get(blocking), nodes );
            System.out.println("After: ");
            System.out.println("public key of blocked: "+ nodes.get(blocked).getU() + " | private key: " + nodes.get(blocked).getV() );
            System.out.println("public key of blocking: "+ nodes.get(blocking).getU() + " | private key: " + nodes.get(blocking).getV() );

        }





    }
}