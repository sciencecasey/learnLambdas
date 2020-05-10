package examples;

import java.util.ArrayList;
import java.util.Collections;

class MyClass{
   private int val;
   MyClass(int v){
      val = v;
   }
   MyClass(){
      val = 0;
   }
   MyClass(String msg){
      System.out.println("This isn't what we want " +msg);
   }
   int getVal() {
      return val;
   }
   
}
public class ReferencesWithCollections {
   /*
    * static comparitor compatable with the Comparator<T> interface within 
    * collections
    */
   static int compareMC(MyClass a, MyClass b) {
      return a.getVal() - b.getVal();
   }
   
   public static void main(String[] args) {
      ArrayList<MyClass> a1 = new ArrayList<MyClass>();
      
      a1.add(new MyClass(1));
      a1.add(new MyClass(11));
      a1.add(new MyClass(5));
      a1.add(new MyClass(6));
      a1.add(new MyClass(19));
      
      
      //create an instance of the MyClass object and use it with the Collections
      //max method comparaing our arraylist of myclasses and the method we defined above
      //why don't we have to pass our method the class a and b objects? 
      MyClass maxValObj = Collections.max(a1, 
            ReferencesWithCollections::compareMC);
      
      System.out.println("Max value is: " + maxValObj.getVal());
   }

}
