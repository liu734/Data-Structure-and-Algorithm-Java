

public class InfixToPostFix{
  public static void main(String[] args){
        Stack<String> operator = new Stack<String>();
        String postfix="";
        while (!StdIn.isEmpty()) {
   String s=StdIn.readString();
   boolean isinteger=!(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("(")||s.equals(")"));
   if(isinteger){
      postfix=postfix+s;
   }
   else if(s.equals("(")||s.equals("*")||s.equals("/"))
      operator.push(s);
   
   else if (s.equals("-")||s.equals("+")){
      while(!operator.isEmpty()&&!operator.peek().equals("(")){
          postfix+=operator.pop();
      }
      operator.push(s);
   }
   else if (s.equals(")")){
     while(!operator.peek().equals("(")){
       postfix+=(operator.pop());
       
     }
     operator.pop();
   }
 }
        while(!operator.isEmpty()){
             postfix+=(operator.pop());
        }
        
        while(!postfix.isEmpty()){
          
        }
  System.out.println(postfix);

}
}