package examples;


interface BoolArray<T>{
   int func(T[] vals, T v);
}
/*
 * 
 */
class ArrayMatch{
   static <T> int countMatching(T[] vals, T v) {
      int count = 0;
      for (int i = 0; i<vals.length; i++) {
         if(vals[i] == v) {
            count ++;
         }
      }
      return count;
   }
}
public class GenericReference {
   /*
    * 
    */
   static<T> int myOp(BoolArray<T> f, T[] vals, T v) {
      return f.func(vals, v);
   }
   public static void main(String[] args) {
      Integer[] intArray = {1, 2, 3, 4, 5};
      String[] strArray = {"One", "Two", "Three"};
      int count;
      
      count = myOp(ArrayMatch::<Integer>countMatching, intArray, 4);
      System.out.println("Matching 4: " + count);
      count = myOp(ArrayMatch::<String>countMatching, strArray, "One");
      System.out.println("Matching One: " + count);

   }

}
