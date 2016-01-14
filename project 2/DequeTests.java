public class DequeTests{
      public static void main(String[] args) {
        Deque<String> q = new Deque<String>();
 String test=StdIn.readString();
 if(test.equals("1")){
 int n=Integer.parseInt(StdIn.readString());
 
 while (!StdIn.isEmpty()){
     q.addLast(StdIn.readString());
 }
 

 for(int i=0; i<n;i++){
    q.addLast(q.removeFirst());
 }

        StdOut.println(q.toString());
 
 }
 
 else if(test.equals("2")){
   Deque<String> q2 = new Deque<String>();
   String index=StdIn.readString();
   while (!index.equals("-")){
     q.addLast(index);
     index=StdIn.readString();
   }
    while (!StdIn.isEmpty()){     
     q2.addLast(StdIn.readString());
    }
    boolean is=false;
    for(int i=0;i<q.size();i++){
       q.addLast(q.removeFirst());
       if(q.toString().equals(q2.toString())){
         is=true;
       }
    }
    if(is)
    StdOut.println("Yes");
    StdOut.println("No");
   
 }
 
 }
}
