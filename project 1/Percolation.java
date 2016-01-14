import java.awt.*;

public class Percolation{
  Color[][] graph;
  int n;
  UF uf;
  public Percolation(int n ){
    uf = new UF(n);
    this.n = n;
    graph=new Color[n][n];
    for (int i=0; i<n;i++)
    for (int j=0; j<n;j++)
    graph[i][j]=StdDraw.BLACK;
    
  }
  
  public void open(int x,int y){
    graph[x][y]=StdDraw.WHITE;
    
    
    
    
  }
  public boolean isOpen(int x,int y){
    if (graph[x][y].equals(StdDraw.WHITE))
    return true;
    else return false;
  }
  public boolean isFull(int x,int y){
    if (graph[x][y].equals(StdDraw.BLUE))
    return true;
    else  return false;
  }
  public boolean percolates(){
    for (int j=0; j<n;j++)
      for (int i=0; i<n;i++)
      if (graph[i][j].equals(StdDraw.WHITE)&&graph[i][j+1].equals(StdDraw.WHITE))
      uf.union(n*j+i, n*j+i+1);
    
    
      

      
    
 
    
    return true;
  }
  
  public static void main(String[] args){
     int N = StdIn.readInt();
     Percolation p=new Percolation(N);   
        
        
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            int y = StdIn.readInt();
            p.open(x,y);
            
        }
        if (p.percolates())
        StdOut.println("Yes");
        else StdOut.println("No");
  }
}  
  
class UF {
    private int[] id;    // id[i] = parent of i
    private int[] sz;    // sz[i] = number of objects in subtree rooted at i
    private int count;   // number of components

   /**
     * Create an empty union find data structure with N isolated sets.
     */
    public UF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

   /**
     * Return the id of component corresponding to object p.
     */
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

   /**
     * Return the number of disjoint sets.
     */
    public int count() {
        return count;
    }

  
   /**
     * Are objects p and q in the same set?
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

  
   /**
     * Replace sets containing p and q with their union.
     */
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        // make smaller root point to larger one
        if   (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else                 { id[j] = i; sz[i] += sz[j]; }
        count--;
    }
}

  



