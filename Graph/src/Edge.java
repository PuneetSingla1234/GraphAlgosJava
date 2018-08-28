
public class Edge{
	int vertex;
	int weight;
	public Edge(int vertex,int weight) {
		this.vertex=vertex;
		this.weight=weight;
	}
	@Override
	public String toString() {
		String res="Vertex: "+vertex+" Weight:"+weight;
		return res;
	}
}

