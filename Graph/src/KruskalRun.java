import java.io.*;
import java.util.*;
class Kruskal{
	AdjacencyList g1;
	int n;
	
	int par[];
	LinkedList<Edge2> edge;
	LinkedList<Edge2> selected;
	class Edge2{
		int src;
		int dest;
		int weight;
		Edge2(int src,int dest,int weight){
			this.src=src;
			this.dest=dest;
			this.weight=weight;
		}
		public String toString() {
			return "\nSource:"+src+" Destination:"+dest+" Weight:"+weight;
		}
	}
	class comp implements Comparator<Edge2>{
		public int compare(Edge2 e1,Edge2 e2) {
			if(e1.weight>=e2.weight)
				return 1;
			else return -1;
		}
		
	}
	
	Kruskal(AdjacencyList g1,int n){
		this.g1=g1;
		this.n=n;
		selected=new LinkedList<Edge2>();
		par=new int[n];
		for(int i=0;i<n;i++) {
			par[i]=-1;
		}
		edge=new LinkedList<Edge2>();
	}
	public void createEdge() {
		for(int i=0;i<n;i++) {
			LinkedList<Edge> ll=g1.al.get(i);
			ListIterator<Edge> li=ll.listIterator();
			while(li.hasNext()) {
				Edge e1=li.next();
				Edge2 newedge=new Edge2(i,e1.vertex,e1.weight);
				edge.add(newedge);
			}
		}
		edge.sort(new comp());
	}
	public int find(int x) {
		if(par[x]==-1)
			return x;
		else return find(par[x]);
	}
	public void union(int x,int y) {
		par[y]=x;
	}
	public void create() {
		createEdge();
		int count=0;
		while(count<n-1) {
			
			Edge2 e=edge.removeFirst();
			int xset=find(e.src);
			int yset=find(e.dest);
			if(xset==yset)
				continue;
			union(xset,yset);
			selected.add(e);
			count++;
		}
		selected.sort(new comp());
	}
}
public class KruskalRun {
	public static void main(String args[]) throws IOException{
		AdjacencyList g1=new AdjacencyList(9);
		g1.create();
		Kruskal k1=new Kruskal(g1,9);
		k1.create();
		System.out.println(k1.selected);
	}
}
