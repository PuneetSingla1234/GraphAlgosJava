import java.util.*;
import java.io.*;
class Longest{
	int n;
	AdjacencyList g1;
	int dist[];
	Longest(int n,AdjacencyList g1){
		this.n=n;
		this.g1=g1;
		
		dist=new int[n];
		for(int i=0;i<n;i++) {
			dist[i]=-1;
		}
	}
	public void create() throws IOException{
		DFSCreation dfs1=new DFSCreation(n,g1);
		dfs1.create(); 
		LinkedList<Integer> stack=new LinkedList<Integer>(dfs1.stack);
		dist[0]=0;
		
		while(!stack.isEmpty()) {
			int u=stack.pop();
			LinkedList<Edge> ll=g1.al.get(u);
			ListIterator<Edge> li=ll.listIterator();
			while(li.hasNext()) {
				Edge v=li.next();
				if(dist[u]!=-1) {
					if(dist[u]+v.weight>dist[v.vertex]) {
						dist[v.vertex]=dist[u]+v.weight;
					}
				}
			}
		}
	}
	public void display() {
		System.out.println("\nLongest Distances:");
		for(int i=0;i<n;i++) {
			System.out.println(""+i+":"+dist[i]);
		}
	}
}
public class LongestPath {
	public static void main(String args[])throws IOException {
		AdjacencyList g1=new AdjacencyList(10);
		g1.create();
		Longest l=new Longest(10,g1);
		l.create();
		l.display();
	}
}
