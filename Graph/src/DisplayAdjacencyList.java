import java.io.IOException;
public class DisplayAdjacencyList {
	public static void main(String args[])throws IOException {
		AdjacencyList g1=new AdjacencyList(5);
		g1.create();
		g1.display();
		AdjacencyList g2=new AdjacencyList(5);
		g2.complement(g1);
		g2.display();
	}
}
