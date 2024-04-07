import java.sql.SQLOutput;
import java.util.ArrayList;

public class Node {
    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    private int u;
    private int v;
    private ArrayList<Integer> blocked;
    private ArrayList<Integer> blocking;

    public Node(int u, int v)
    {
        this.u=u;
        this.v=v;
        blocked = new ArrayList<>();
        blocking = new ArrayList<>();
    }

    public void addBlocked(int index)
    {
        blocked.add(Integer.valueOf(index));
    }

    public void addBlocking(int index, Node node, ArrayList<Node> nodes)
    {
        blocking.add(Integer.valueOf(index));
        this.v=this.u*node.u+1;
        this.u=this.u*node.u+1;

        this.transmit(nodes);

    }

    public void transmit(ArrayList<Node> nodes)
    {
        for(int i : this.blocking)
        {
            if(this.u==nodes.get(i).u && this.u == this.v)
            {
                System.out.println("Deadlock is detected");
                return;
            }
            this.u=Math.max(this.u, nodes.get(i).u);

        }

        for(int i : this.blocked)
        nodes.get(i).transmit(nodes);

    }




}
