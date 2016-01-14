
    import java.awt.geom.*;
    import java.util.*;
    import java.lang.*;
      public class RobustConvexHull {
      ArrayList <Point2D.Double> convex;



    public RobustConvexHull(int n) {// Create an empty point set that can accommodate n points
      convex= new ArrayList <Point2D.Double>(n);
      


    }
    public void add(double x, double y) {//Add a point P(x,y) to the point set.
      Point2D.Double myPoint = new Point2D.Double(x,y);
      convex.add(myPoint);
    }
    public int whichSide(double x0, double y0, double x1, double y1, double x, double y){ //Indicate on which side of the line passing through (x0,y0) and (x1,y1) the point (x,y) is located (-1: right, 0: on the line, 1: left)
      if(((x0==x)&&(y0==y))||((x1==x)&&(y1==y))) return 0;
      if(x1!=x0){
     // double k=(y1-y0)/(x1-x0);
      //double a= y0-k*x0;
      double y2=(y1-y0)/(x1-x0)*x+y0-(y1-y0)/(x1-x0)*x0;
     // System.out.println("y="+y+"y2="+y2+"y-y2"+(y-y2));
      if (((x1>x0)&&(y>y2))||((x1<x0)&&(y<y2)))
      {
      return 1;}
      else if(y==y2) return 0;
      else if (((x1>x0)&&(y<y2))||((x1<x0)&&(y>y2))) return -1;
      }
      else if ((y1>y0 && x<x1)||(y1<y0 && x>x1))       {return 1;}
      else if ((y1>y0 && x>x1)||(y1<y0 && x<x1)) return -1;
      return 0;
      
    }

      public static void main(String[] args){  //Create a main method that reads a description of the points from standard input (using StdIn.java) and prints to standard output the list of points forming the convex hull in this format: id0 (x0, y0), id1 (x1, y1), ..., idM (xM, yM) (using StdOut.java). 
      int n=StdIn.readInt();
      RobustConvexHull convexSet=new RobustConvexHull(n);
      
      
      while (!StdIn.isEmpty()){
      double x=StdIn.readDouble();
      double y=StdIn.readDouble();
      convexSet.add(x,y);
      
     }
      

     ArrayList <Point2D.Double> oldconvex= new ArrayList <Point2D.Double>(n);
     for(int i=0; i<convexSet.convex.size();i++){
      
      oldconvex.add(convexSet.convex.get(i));


    }



     Point2D.Double point0;
     Point2D.Double point1;
     Point2D.Double point2;
     
           ArrayList <Integer> index=new ArrayList  <Integer> ();
           for(int i=0; i<convexSet.convex.size();i++ ){
           index.add(i);
           
           }
           
           
      for (int i=0; i+1<convexSet.convex.size();i++ ){
      for (int j=0; j+1<convexSet.convex.size();j++){
	point0=convexSet.convex.get(j);
      point1=convexSet.convex.get(j+1);
      int p0=index.get(j);
      int p1=index.get(j+1);
      int p2;
      if(point0.getX()>point1.getX()){
	point2=point0;
	p2=p0;
	convexSet.convex.set(j,point1);
	index.set(j,p1);
	convexSet.convex.set(j+1,point2);
	index.set(j+1,p2);
      }
      else if(point0.getX()==point1.getX()){
	if(point0.getY()<point1.getY()){
	point2=point0;
	p2=p0;
	convexSet.convex.set(j,point1);
	index.set(j,p1);
	convexSet.convex.set(j+1,point2);
	index.set(j+1,p2);
	  
	}
      }
      }
      }

      

      
      //for (int i=0; i<convexSet.convex.size();i++ ){
 //point=convexSet.convex.get(i);
 //StdOut.println(point.getX());
      //}
      ArrayList <Integer> Lupper=new ArrayList  <Integer> ();
      
      Lupper.add(0);
      Lupper.add(1);
      for (int i=2;i<convexSet.convex.size();i++){
 Lupper.add(i);
   point0=convexSet.convex.get(Lupper.get(Lupper.size()-3));
   point1=convexSet.convex.get(Lupper.get(Lupper.size()-2));
   point2=convexSet.convex.get(Lupper.get(Lupper.size()-1));
   
 while (convexSet.whichSide(point0.getX(),point0.getY(),point1.getX(),point1.getY(),point2.getX(),point2.getY())!=1&&Lupper.size()>2){
   Lupper.remove(Lupper.size()-2);
   if(Lupper.size()>2){
   point0=convexSet.convex.get(Lupper.get(Lupper.size()-3));
   point1=convexSet.convex.get(Lupper.get(Lupper.size()-2));
   point2=convexSet.convex.get(Lupper.get(Lupper.size()-1));
   }
 }
 
      }

      ArrayList <Integer> Llower=new ArrayList  <Integer> ();
      Llower.add(convexSet.convex.size()-1);
      Llower.add(convexSet.convex.size()-2);
      for (int i=(convexSet.convex.size()-3);i>0;i--){
 Llower.add(i);
   point0=convexSet.convex.get(Llower.get(Llower.size()-3));
   point1=convexSet.convex.get(Llower.get(Llower.size()-2));
   point2=convexSet.convex.get(Llower.get(Llower.size()-1));

 while (convexSet.whichSide(point0.getX(),point0.getY(),point1.getX(),point1.getY(),point2.getX(),point2.getY())!=1&&Llower.size()>2){
   Llower.remove(Llower.size()-2);
   if(Llower.size()>2){
   point0=convexSet.convex.get(Llower.get(Llower.size()-3));
   point1=convexSet.convex.get(Llower.get(Llower.size()-2));
   point2=convexSet.convex.get(Llower.get(Llower.size()-1));
   }
 }
      }

      Llower.remove(Llower.size()-1);
      Llower.remove(0);

      for(int i=0; i<Llower.size();i++){
      Lupper.add(Llower.get(i));
      }
      Llower=new ArrayList  <Integer> ();

      for(int i=0;i<Lupper.size();i++) {
	int temp=index.get(Lupper.get(i));
	Llower.add(temp);

      }
      int minIndex=0;
      for(int i=0;i<Llower.size();i++){
	if(Llower.get(i)<Llower.get(minIndex))
	    minIndex=i;
      }

      ArrayList <Integer> output=new ArrayList  <Integer> ();
      for(int i=minIndex;i<Llower.size();i++){
	output.add(Llower.get(i));
      }

      for(int i=0;i<minIndex;i++){
	output.add(Llower.get(i));
      }

      
      for (int i=0; i<output.size();i++){
	StdOut.print(output.get(i)+" ("+oldconvex.get(output.get(i)).getX()+", "+oldconvex.get(output.get(i)).getY()+")");
	if((i+1)!=output.size()) StdOut.print(", "); else StdOut.print("\n");
	

}

      


}

}










