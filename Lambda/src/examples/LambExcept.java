package examples;

/*
 * functional interface with custom emptyarrayexception 
 */
interface DoubleNumericArrayFunc{
   double func(double[] n) throws EmptyArrayException;
}

class EmptyArrayException extends Exception {
   //default compilation
   EmptyArrayException(){
      //pass message to Exception compiler
      super("Array Empty");
   }
   
   private static final long serialVersionUID = 1L;
}

public class LambExcept {
   
 
   public static void main(String[] args) throws EmptyArrayException {
      double[] values = {1d, 2d, 3d, 4.0};
      
      //create the block lambda
      DoubleNumericArrayFunc avg = (n) ->{
         double sum = 0;
         
         if (n.length == 0) {
            throw new EmptyArrayException();
         } else {
            //loop through whole array
            for (double i:n) {
               //i starts with 1?
               sum +=n[(int) i-1];
            }
            return sum/n.length;
         }
      };
      
      System.out.println("Average is: " + avg.func(values));
      
      try {
         //throws exception
         System.out.println("Average is: " + avg.func(new double[0]));
      } catch(EmptyArrayException e) {
         System.out.println("Caugtcha");
      }
   }

}
