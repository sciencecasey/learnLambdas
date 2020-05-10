package examples;

public class LambChangeVars {
   //declare var to use with setter
   int numSetter;
   
   /*
    * use static variable
    */
   static int statNum = 12;
   /*
    * change the numSetter var to k
    */
   void setNum(int k){
      this.numSetter = k;
   }

   public static void main(String[] args) {
      int num = 10; //local variable
      
      //use the local var in lamda operations
      NumericFunc localLam = (n) ->{
         //declare new variable value is okay, but only local
         int v = num + n;
         
         //can't modify the var in main
         //this.num = 8;
         
         //can return the local value to use it
         return v;
      };
      System.out.println("This is the local variable: " + num);
      System.out.println("This is the new variable: " + localLam.funct(8));
      
      //even if the var is now outside the lambda, inorder for lambda to use it 
      //must not be changed within the instance
      //num = 8;
      
      //static var lambda operations
      System.out.println("\nNow try the static variable, value: " + statNum);
      NumericFunc statLam = (n) -> {
         //can change the static variable directly
         statNum += n;
         //return the val to add (not the aim of the method just to check
         return n;
      };
      //run staticlambda
      System.out.println("The value of the function is: " 
            + statLam.funct(7));
      System.out.println("Now the static variable is: " + statNum);
      
      
      //setter method lambda operations 
      //call the class instance
      LambChangeVars myInstance = new LambChangeVars();
      System.out.println("\nThe instance var is: " + myInstance.numSetter);
      
      //create lambda that calls to setter
      NumericFunc setterLam = (n) -> {
         System.out.println("In the lambda");
         //setNum of the reference instance to value of n
         myInstance.setNum(n);
         //return the value set
         return n;
      };
      System.out.println("The lamda uses: " + setterLam.funct(6));
      System.out.println("And the instance var is: " + myInstance.numSetter);
      
      //note that we can't access the instance variable directly within instance
      //because lambda needs "effectively final" variable
      //BUT we can still access the setters
      //myInstance.numSetter(8);
      myInstance.setNum(8);
   }

}
