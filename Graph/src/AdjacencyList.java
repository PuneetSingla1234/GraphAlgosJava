import java.util.*;
import java.io.*;
public class AdjacencyList {
	public int n;
	public ArrayList<LinkedList<Edge>> al;
	public AdjacencyList(int n) {
		this.n=n;
		al=new ArrayList<LinkedList<Edge>>();
		for(int i=0;i<n;i++) {
			LinkedList<Edge> ll=new LinkedList<Edge>();
			al.add(ll);
		}
	}
	public void addEdge(int u,int v,int w) {
		Edge e=new Edge(v,w);
		LinkedList<Edge> l=al.get(u);
		l.add(e);
	}
	public void removeEdge(int u,int v,int w) {
		LinkedList<Edge> l=al.get(u);
		l.remove(new Edge(v,w));
	}
	public void display() {
		for(int i=0;i<n;i++) {
			System.out.println(""+i+". "+al.get(i));
		}
	}
	public void complement(AdjacencyList g1) {
		for(int i=0;i<n;i++) {
			LinkedList<Edge>llo=g1.al.get(i);
			ListIterator<Edge> lo=llo.listIterator();
			while(lo.hasNext()) {
				Edge c=lo.next();
				addEdge(c.vertex,i,c.weight);
			}
		}
	}
	public void create ()throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String edge="";
		System.out.println("Enter all the edges:");
		while((edge=br.readLine())!=null&&edge.length()!=0) {
			String arr[];
			arr=edge.split(" ");
			int e[]=new int[3];
			e[0]=Integer.valueOf(arr[0]);
			e[1]=Integer.valueOf(arr[1]);
			e[2]=Integer.valueOf(arr[2]);
			addEdge(e[0],e[1],e[2]);
		}
	}
}
