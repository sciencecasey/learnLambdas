package examples;

//create a static method to reference
class MyStaticStringOps{
   /*
    * @param str: the String to reverse
    * @return the input str in reverse
    */
   static String strReverse(String str) {
      String result = "";
      for (int i = str.length()-1; i>=0; i--) {
         result += str.charAt(i);
      }
      return result;
   }
}


/*
 * 
 */
public class StaticMethodReferences {
   /*
    * @param sf a reference to the StringFunc functional interface or to a 
    *  static method that matches target interface
    * @param s the String for the interface method to operate on
    * @return the operation result of the interface reference method's operation
    */
   static String stringOp(StringFunc sf, String s) {
      //this is the result of StringFunc which isn't defined here, 
      //should be defined by sf in order to use this method
      return sf.func(s);
   }
   
   public static void main(String[] args) {
      String inStr = "Referencing Methods is like using a Lambda. "
            + "Is it a Lambda?";
      String outStr;
      
      //assign outsting by calling the local stringOp static method, which
      //takes a parameter of functional interface reference type.  Pass the 
      //Class::methodName as this interface reference (even though not declared
      //as such)  
      outStr = stringOp(MyStaticStringOps::strReverse, inStr);
      System.out.println("Static method reference: ");
      System.out.println("Original String: " + inStr);
      System.out.println("Reversed: " + outStr);
   }

}
