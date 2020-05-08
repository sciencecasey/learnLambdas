package examples;

/*
 * 
 */

public class BlockLam {

   public static void main(String[] args) {
      NumericFunc factorial = (n) -> {
         int result = 1;
         
         for (int i = 1; i <= n; i++) {
            result = i * result;
         }
         return result;
      };
      
      System.out.println("The factorial of 3 is " + factorial.funct(3));
      System.out.println("The factorial of 5 is " + factorial.funct(5));
      
      System.out.println();
      
      //reverses the characters in a string
      StringFunc reverse = (str) -> {
         String result = "";
         int i;
         
         for (i = str.length() -1; i>=0; i--) {
            result += str.charAt(i);
         }
         return result;
      };
      
      System.out.println("Lambda reversed is: " + reverse.func("Lambda"));
      //yes!
      System.out.println("Does this work with spaces?: " + reverse.func("Casey Jayne"));
      //only removes leading and following whitespace, doesn't change the above
      System.out.println("Does this work with spaces?: " + reverse.func("Casey Jayne").strip());
      
      
      System.out.println("\nNow for Generics");
      
      GenericFunc<String> reverse2 = (str) ->{
         String result = "";
         int i;
         for (i = str.length() -1; i>=0; i--) {
            result += str.charAt(i);
         }
         return result;
      };
      
      System.out.println("Lambda reversed is: " + reverse2.func("Lambda"));
      //yes!
      System.out.println("Does this work with spaces?: " + reverse2.func("Casey Jayne"));
      
      
      System.out.println();
      
      GenericFunc<Double> factorial2 = (n) -> {
         Double result = 1d;
         for (Double i = 1d; i <= n; i++) {
            result = i * result;
         }
         return result;
      };
      //remove decimals and add commas
      
      System.out.printf("The factorial of 30 is %,.0f %n", factorial2.func((double) 30));
      //toobig! Interesting :) 
      System.out.printf("The factorial of 50 is %,.0f %n", factorial2.func(50d));
   }
}
