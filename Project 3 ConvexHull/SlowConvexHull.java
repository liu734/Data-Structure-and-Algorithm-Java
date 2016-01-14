    import java.awt.*;
    import java.awt.geom.*;
    import java.util.*;
    import java.lang.*;


    public class SlowConvexHull{
      ArrayList <Point2D.Double> convex;



    public SlowConvexHull(int n) {// Create an empty point set that can accommodate n points
      convex= new ArrayList <Point2D.Double>(n);
      


    }
    public void add(double x, double y) {//Add a point P(x,y) to the point set.
      Point2D.Double myPoint = new Point2D.Double(x,y);
      convex.add(myPoint);
    }
    public int whichSide(double x0, double y0, double x1, double y1, double x, double y){ //Indicate on which side of the line passing through (x0,y0) and (x1,y1) the point (x,y) is located (-1: right, 0: on the line, 1: left)
      if(x1!=x0){
      double k=(y1-y0)/(x1-x0);
      double a= y0-k*x0;
      double y2=k*x+a;
      if (((x1>x0)&&y>y2)||((x1<x0)&&(y<y2)))
 return 1;
      else if(y==(k*x+a)) return 0;
      else if (((x1>x0)&&(y<y2))||((x1<x0)&&(y>y2))) return -1;
      }
      else if (x1>x0 && x<x1) return 1;
      else if (x1>x0 && x>x1) return -1;
      return 0;
      
    }
    public static void main(String[] args){  //Create a main method that reads a description of the points from standard input (using StdIn.java) and prints to standard output the list of points forming the convex hull in this format: id0 (x0, y0), id1 (x1, y1), ..., idM (xM, yM) (using StdOut.java). 
      int n=StdIn.readInt();
      SlowConvexHull convexSet=new SlowConvexHull(n);
      ArrayList <Point2D.Double> hull=new ArrayList <Point2D.Double>();
    
      while (!StdIn.isEmpty()){
 double x=StdIn.readDouble();
 double y=StdIn.readDouble();
 convexSet.add(x,y);
     }
     
     Point2D.Double point0;
     Point2D.Double point1;
     Point2D.Double point;
    
      
     for (int i=0; i<convexSet.size();i++ ){
 for (int j=0; j<convexSet.size();j++){
   point0=convexSet.get(i);
   point1=convexSet.get(j);
   boolean is=true;
   for (int k=0;k<convexSet.size();k++){
     point=convexSet.get(k);
     if(whichSide(point0.getX(),point0.getY(),point1.getX(),point1.getY(),point.getX(),point.getY())!=1){
     is=false;
     break;
     }
   }
     if(is==true){
       hull.add(point0);
       hull.add(point1);
     }
     
 }
 }
     
     for (int i=0;i<hull.size();i=i+2){
            
     }

      

}
    



}