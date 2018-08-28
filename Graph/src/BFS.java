import java.io.*;
import java.util.*;
class BFSCreation{
	private int n;
	int par[];
	int dis[];
	int com[];
	int time=0;
	BFSCreation(int n){
		this.n=n;
		par=new int[n];
		dis=new int[n];
		com=new int[n];
		for(int i=0;i<n;i++) {
			par[i]=-1;
			dis[i]=-1;
			com[i]=-1;
		}
	}
	public void create() throws IOException{
		AdjacencyList g1=new AdjacencyList(n);
		g1.create();
		LinkedList<Integer> queue=new LinkedList<Integer>();
		int curr=0;
		for(int i=0;i<n;i++) {
			if(dis[i]==-1) {
				dis[i]=time;
				time++;
				queue.add(i);
				while(!queue.isEmpty()) {
					curr=queue.removeFirst();
					System.out.print(" "+curr);
					com[curr]=time;
					time++;
					LinkedList<Edge> ll=g1.al.get(curr);
					ListIterator<Edge> li=ll.listIterator();
					while(li.hasNext()) {
						Edge c=li.next();
						if(dis[c.vertex]==-1) {
							dis[c.vertex]=time;
							time++;
							par[c.vertex]=curr;
							queue.addLast(c.vertex);
						}
					}
				}
			}
		}
	}
}
public class BFS {
	
	public static void main(String args[]) throws IOException{
		BFSCreation bfs1=new BFSCreation(5);
		bfs1.create();
	}
}
