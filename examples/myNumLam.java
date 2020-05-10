package examples;

public class myNumLam {
   
   //define an enclosing interface 
   interface NumericTest2{
      boolean test(int n, int d);
   }
   public static void main(String[] args) {
      //create reference to the interface
      myNumber myNum;
      //define the mehod with a lambda operation
      myNum = () -> 123.45;
      //now the one method value of the interface returns the lambda definition of the interface
      System.out.println(myNum.getValue());
      
      
      //more complex expression
      myNum = () -> Math.random();
      System.out.println("random val 1: " +myNum.getValue());
      System.out.println("random val 2: " +myNum.getValue());
      
      //lambda expression must return the same type as the interface (double)
      //myNum = () -> "12.35"; can't be converted to double bc string
      myNum = () -> Double.parseDouble("1234"); //this works (but why) 
      System.out.println(myNum.getValue());
      
      //use a difference interface to define 2 different numeric tests
      System.out.println();
      NumericTest isEven;
      NumericTest nonNeg;
      isEven = (n) -> (n%2) == 0;
      nonNeg = (n) -> n >= 0;
      
      if (isEven.test(10)) {
         System.out.println("10 is not negative");
      }
      
      if (nonNeg.test(-1)) {
         System.out.println("-1 is not negative");
      }
      
      if (nonNeg.test(1)) {
         System.out.println("1 is not negative");
      }
      
      //take 2 inferred params 
      System.out.println();
      NumericTest2 isFactor = (n, d) -> (n % d) == 0;
      //use it
      //note the SAME test name can be used by different interfaces with different params without needing to write method overrides, etc
      if (isFactor.test(10, 2)){
         System.out.println("2 is a factor of 10");
      }
      if (isFactor.test(2, 10)) {
         //this isn't true!
         System.out.println("10 is a factor of 2");
      }
      
      
   }

}
