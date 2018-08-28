import java.io.*;
import java.util.*;
class AllTopologicalSorts{
	LinkedList<Integer> ll;
	AdjacencyList g1;
	int n;
	int visited[];
	int indegree[];
	AllTopologicalSorts(int n,AdjacencyList g1){
		this.n=n;
		this.g1=g1;
		ll=new LinkedList<Integer>();
		visited=new int[n];
		indegree=new int[n];
		for(int i=0;i<n;i++) {
			visited[i]=-1;
			indegree[i]=0;
		}
	}
	public void computeindegree() {
		for(int i=0;i<n;i++) {
			LinkedList<Edge> l=g1.al.get(i);
			ListIterator<Edge> li=l.listIterator();
			while(li.hasNext()) {
				Edge e=li.next();
				indegree[e.vertex]++;
			}
		}
	}
	public void ats() {
		boolean flag=false;
		for(int i=0;i<n;i++) {
			if(visited[i]==-1&&indegree[i]==0) {
				ll.addLast(i);
				visited[i]=1;
				LinkedList<Edge> l=g1.al.get(i);
				ListIterator<Edge> li=l.listIterator();
				while(li.hasNext()) {
					Edge e=li.next();
					indegree[e.vertex]--;
				}
				ats();
				visited[i]=-1;
				li=l.listIterator();
				while(li.hasNext()) {
					Edge e=li.next();
					indegree[e.vertex]++;
				}
				visited[i]=-1;
				flag=true;
				ll.removeLast();
			}
			
		}
		if(!flag) {
			System.out.println(ll);
		}
	}
	public void create() {
		computeindegree();
		ats();
	}
}
public class AllTopologicalSortsRun {
	public static void main(String args[]) throws IOException{
		AdjacencyList g1=new AdjacencyList(6);
		g1.create();
		AllTopologicalSorts a=new AllTopologicalSorts(6,g1);
		a.create();
	}
}
