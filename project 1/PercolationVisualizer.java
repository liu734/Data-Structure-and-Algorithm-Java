import java.awt.*;

public class PercolationVisualizer{
    Color[][] graph;
  int n;
  WeightedQuickUnionUF uf;
  public PercolationVisualizer(int n ){
    uf = new WeightedQuickUnionUF(n);
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

    return true;
  }
  
  public static void main(String[] args){
     int N = StdIn.readInt();
     Percolation p=new Percolation(N);   
     
     StdDraw.setCanvasSize(N,N);
     
        
        
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