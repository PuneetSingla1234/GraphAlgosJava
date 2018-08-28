import java.io.*;
import java.util.*;
class DFSCreation{
	private int n;
	int par[];
	int dis[];
	int com[];
	int time=0;
	boolean cycle=false;
	public LinkedList<Integer> stack;
	AdjacencyList g1;
	DFSCreation(int n,AdjacencyList g1){
		this.n=n;
		this.g1=g1;
		par=new int[n];
		dis=new int[n];
		com=new int[n];
		for(int i=0;i<n;i++) {
			par[i]=-1;
			dis[i]=-1;
			com[i]=-1;
		}
		stack=new LinkedList<Integer>();
		
	}
	public void DFSUtil(int s) {
			LinkedList<Edge> ll=g1.al.get(s);
			ListIterator<Edge> li=ll.listIterator();
			while(li.hasNext()) {
				Edge n=li.next();
				if((dis[n.vertex]!=-1)&&(com[n.vertex]==-1)) {
					cycle=true;
				}
				if(dis[n.vertex]==-1) {
					par[n.vertex]=s;
					dis[n.vertex]=time;
					System.out.print(" "+n.vertex);
					time++;
					DFSUtil(n.vertex);
				}
			}
			stack.push(s);
			com[s]=time;
			time++;
	}
	public void create() throws IOException{
		
		for(int i=0;i<n;i++) {
			if(dis[i]==-1) {
				dis[i]=time;
				time++;
				System.out.print(" "+i);
				DFSUtil(i);
		}
		}
	}
	
}
public class DFS{
	public static void main(String args[]) throws IOException{
		
		AdjacencyList g1=new AdjacencyList(5);
		g1.create();
		DFSCreation d1=new DFSCreation(5,g1);
		d1.create();
		if(d1.cycle) {
			System.out.println("\nContains A Cycle.");
		}
	}
}
