import java.io.*;
import java.util.*;
class Prim{
	AdjacencyList g1;
	int s;
	int n;
	PriorityQueue<Vertexkey> pq;
	TreeSet<Vertexkey> select;
	boolean chosen[];
	Prim(AdjacencyList g1,int s,int n){
		this.g1=g1;
		this.s=s;
		this.n=n;
		chosen=new boolean[n];
		pq=new PriorityQueue<Vertexkey>(new comp());
		select=new TreeSet<Vertexkey>(new comp());
		for(int i=0;i<n;i++) {
			chosen[i]=false;
			if(i!=s) {
				Vertexkey vk=new Vertexkey(i,10000,-1);
				pq.add(vk);
			}
			else{
				Vertexkey vk=new Vertexkey(i,0,-1);
				pq.add(vk);
			}
		}
	}
	
	public void create() {
		int i=0;
		while(i<n-1) {
			Vertexkey selected=pq.poll();
			System.out.println(selected);
			if(chosen[selected.vertex])
				continue;
			i++;
			System.out.println("Selected: selected");
			chosen[selected.vertex]=true;
			select.add(selected);
			int u=selected.vertex;
			int k=selected.key;
			LinkedList<Edge> l=g1.al.get(u);
			ListIterator<Edge> li=l.listIterator();
			while(li.hasNext()) {
				Edge e=li.next();
				int vertex=e.vertex;
				pq.add(new Vertexkey(vertex,k+e.weight,u));
			}
		}
	}
}
class Vertexkey{
	int vertex;
	int key;
	int parent;
	Vertexkey(int vertex,int key,int parent){
		this.vertex=vertex;
		this.key=key;
		this.parent=parent;
	}
	public String toString() {
		return "\nVertex:"+vertex+" Key:"+key+" Parent:"+parent;
	}
}
class comp implements Comparator<Vertexkey>{
	public int compare(Vertexkey vk1,Vertexkey vk2) {
		if(vk1.key>=vk2.key)
			return 1;
		else return -1;
	}
}
public class PrimRun{
	public static void main(String args[]) throws IOException{
		AdjacencyList g1=new AdjacencyList(6);
		g1.create();
		Prim p=new Prim(g1,0,6);
		p.create();
		System.out.println(p.select);
	}
}
