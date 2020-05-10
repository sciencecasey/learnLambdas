package examples;

class MyStringOps{
   /*
    * @param str: the String to reverse
    * @return the input str in reverse
    */
   public String strReverse(String str) {
      String result = "";
      for (int i = str.length()-1; i>=0; i--) {
         result += str.charAt(i);
      }
      return result;
   }
}



public class nonStaticMethodReference {
   /*
    * just testing if I can do this nonstatic
    */
   String nonStaticStringOp(StringFunc sf, String s) {
      return sf.func(s);
   }
   
   static String staticStringOp(StringFunc sf, String s) {
      return sf.func(s);
   }
   public static void main(String[] args) {
      String inStr = "Referencing Methods is like using a Lambda. "
            + "Is it a Lambda?";
      String outStr;
      
      
      MyStringOps nonStatic = new MyStringOps();
      //assign outsting by calling the local stringOp static method, which
      //takes a parameter of functional interface reference type.  Pass the 
      //Class::methodName as this interface reference (even though not declared
      //as such)  
      nonStaticMethodReference useInstance = new nonStaticMethodReference();
      outStr = useInstance.nonStaticStringOp(nonStatic::strReverse, inStr);
     
      
      
      //only static works idk why
      outStr = staticStringOp(nonStatic::strReverse, inStr);
      System.out.println("Instance method reference: ");
      System.out.println("Original String: " + inStr);
      System.out.println("Reversed: " + outStr);
      
      
      
      
      
      

   }

}
