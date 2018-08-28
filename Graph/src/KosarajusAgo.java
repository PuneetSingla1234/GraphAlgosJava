import java.util.*;
import java.io.*;
class KosarajusAlgoCreation{
	AdjacencyList g1;
	private int n;
	KosarajusAlgoCreation(int n,AdjacencyList g1){
		this.g1=g1;
		this.n=n;
	}
	public void Algo() throws IOException{
		
		AdjacencyList g2=new AdjacencyList(n);
		g2.complement(g1);
		DFSCreation dfs1=new DFSCreation(n,g1);
		dfs1.create();
		DFSCreation dfs2=new DFSCreation(n,g2);
		LinkedList<Integer> stack1=dfs1.stack;
		System.out.println("\nStack:");
		System.out.println(stack1);
		System.out.println("\nStrongly Connected Components:");
		while(!stack1.isEmpty()) {
			int i=stack1.pop();
			if(dfs2.dis[i]==-1) {
				dfs2.dis[i]=dfs2.time;
				dfs2.time=dfs2.time+1;
				System.out.println("");
				System.out.print(i+" ");
				dfs2.DFSUtil(i);
				dfs2.com[i]=dfs2.time;
				dfs2.time++;
			}
		}
	}
	
	
}
public class KosarajusAgo{
	public static void main(String args[]) throws IOException{
		AdjacencyList g1=new AdjacencyList(10);
		g1.create();
		KosarajusAlgoCreation ta=new KosarajusAlgoCreation(10,g1);
		ta.Algo();
	}
}
