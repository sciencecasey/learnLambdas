package assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * a functional interface of generic Numbers
 */
interface ObjArray<T extends Number>{
   /*
    * @param input an array of objects
    * @return and object of the same type
    */
   T myObjFunc(T[] input);
}

/*
 * create input array and use ObjArray interface with lambdas to calculate 
 * mean, min, and max vals, convert & sort as a list, & calc median
 */
public class LambdaAssign {
    
   public static void main(String[] args) {
      //create array
      Double[] inputArray = {17.64, 55.56, 36.93, 55.96, 20.23, 41.74, 1.8, 
            95.97, 81.89, 36.16, 34.41, 87.9, 13.74, 11.15};
      //create a lambda expression for the maximum
      ObjArray<Double> maximum = (n) ->{
        //initialize to first value
         double biggest= n[0];
     
         //iterate through the second from end of list
         for(int i = 0; i<n.length-1; i++) {
            //iterate from second item through the end
            for(int j = 1; j<n.length; j++) {
               if(biggest>n[i] && biggest>n[j]) {
                  //don't change, already biggest
               }else if(n[i]>= n[j]) {
                  //first val is less than or equal to next val
                  biggest = n[i];
               } else {
                  //second val bigger
                  biggest = n[j];
               }
            }
         }
         return biggest;
      };
      
      //create a lambda expression for minimum
      ObjArray<Double> minimum = (n) -> {
         //start as first item
         double smallest = n[0];
         
         //multi-item arrays, iterate through the second from end of list
         for(int i = 0; i<n.length-1; i++) {
            //from second item to the end
            for(int j = 1; j<n.length; j++) {
               if(smallest<n[i] && smallest<n[j]) {
                  //don't change, already smallest
               }else if(n[i]<= n[j]) {
                  //first val is less than or equal to next val
                  smallest = n[i];
               } else {
                  //second val smaller
                  smallest = n[j];
               }
            }
         }
         return smallest;
      };
      
      //create a lambda expression for average
      ObjArray<Double> average = (n) -> {
         double avg = 0;
         //add every value
         for (int i=0; i<n.length; i++) {
            //autounboxes
            avg += n[i];
         }
         //divide by the number of units
         avg/=n.length;
         return avg;
      };
      
    //calculate the median object
      ObjArray<Double> median = (n) -> {
         Double middle;
         if(n.length==1) {
            //single item array
            middle = n[0];
         } else if(n.length%2!=0) {
            //odd number of values
            //get 1/2 the number of values as the remainder is not returned
            int index = ((n.length/2));
            middle = n[index];
         } else {
            //even items in array
            int index = n.length/2;
            //index is avg of 2 middle vals
            middle = (n[index] + n[index-1])/2;
         }
         return middle;
      };
      
      System.out.println("The largest value is " + 
            maximum.myObjFunc(inputArray));
      System.out.println("The smallest value is " + 
            minimum.myObjFunc(inputArray));
      System.out.println("The average of values is " +
            average.myObjFunc(inputArray));
     
      //create the list
      ArrayList<Double> sortedList= new ArrayList<>(Arrays.asList(inputArray));
      //print sorted list
      Collections.sort(sortedList);
      System.out.println("\nSorted List:");
      for (Double i: sortedList) {
         System.out.print(i + ", ");
      }
      System.out.println();
      
      //Print median from sorted List
      //convert back to array to use with lambda
      Double[] sortArray = new Double[inputArray.length];
      for(int i=0; i<inputArray.length; i++) {
         sortArray[i] = sortedList.get(i);
      }
      System.out.println();
      System.out.println("The median value is: " + median.myObjFunc(sortArray));
   }

}
