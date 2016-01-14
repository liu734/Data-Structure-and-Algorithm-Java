public class Parentheses{
    boolean isBalanced=true;
    public static void main(String[] args) {
     
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            switch(item){
              case "(": s.push("item");
              case "[": s.push("item");
              case "{": s.push("item");
              case ")": if (item.isEmpty()){
                isBalanced=false;
              }
              else {
                String front=s.pop();
                if(front.equals("(")){
                  isBalanced=true;
                }
                else
                  isBalanced=false;
                break;
              }
              case "]": if (item.isEmpty()){
                isBalanced=false;
              }
              else {
                String front=s.pop();
                if(front.equals("[")){
                  isBalanced=true;
                }
                else
                  isBalanced=false;
                break;
              }
              case "}": if (item.isEmpty()){
                isBalanced=false;
              }
              else {
                String front=s.pop();
                if(front.equals("{")){
                  isBalanced=true;
                }
                else
                  isBalanced=false;
                break;
              }
              
              
              
            }
           // if (!item.equals("-")) s.push(item);
            //else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}