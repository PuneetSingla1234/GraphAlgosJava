package GeeksForGeeks;
import java.io.*;
class RC{
	int m,n,k,r;
	int x[];
	int y[];
	int visited[][];
	boolean isPath;
	RC() throws IOException{
		get();
		isPath=false;
		isBlocked();
		isPossible();
	}
	public void get() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		String arr[]=str.split(" ");
		m=Integer.parseInt(arr[0]);
		n=Integer.parseInt(arr[1]);
		k=Integer.parseInt(arr[2]);
		r=Integer.parseInt(arr[3]);
		visited=new int[m][n];
		x=new int[k];
		y=new int[k];
		int count=4;
		for(int i=0;i<k;i++) {
			x[i]=Integer.parseInt(arr[count]);
			count++;
			y[i]=Integer.parseInt(arr[count]);
			count++;
		}
	}
	public void isBlocked() {
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				for(int p=0;p<k;p++) {
					double dist=Math.sqrt(Math.pow(Math.abs(i-y[p]+1), 2)+Math.pow(Math.abs(j-x[p]+1), 2));
					if(dist<=r) {
						System.out.println(" " +i+" "+j);
						visited[i][j]=-1;
						break;
					}
				}
			}
		}
	}
	public boolean isSafe(int a,int b) {
		if(a<0||a>=m||b<0||b>=n)
			return false;
		return true;
	}
	public void isPossible() {
		check(0,0);
	}
	public boolean check(int a,int b) {
		if(!(isSafe(a,b)))
			return false;
		if(visited[a][b]!=0)
			return false;
		if((a==m-1)&&(b==n-1)) {
			System.out.println("Inside");
			isPath=true;
			return true;
		}
		else {
			visited[a][b]=1;
			if(check(a-1,b-1))
				return true;
			if(check(a-1,b))
				return true;
			if(check(a-1,b+1))
				return true;
			if(check(a,b-1))
				return true;
			if(check(a,b+1))
				return true;
			if(check(a+1,b-1))
				return true;
			if(check(a+1,b))
				return true;
			if(check(a+1,b+1))
				return true;
		}
		visited[a][b]=0;
		return false;
		
	}
}
public class RectangleWithCircles {
	public static void main(String args[]) throws IOException{
		RC rc1=new RC();
		if(rc1.isPath)
			System.out.println("Possible");
		else
			System.out.println("Impossible");
	}
}
