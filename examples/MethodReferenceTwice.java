//package examples;
//
//
///*
// * class object that stores the high temperature
// */
//class HighTemp{
//   private int hTemp;
//   /*
//    * set the days temp
//    * @param ht high temperature as integer
//    */
//   HighTemp(int ht){
//      hTemp = ht;
//   }
//   /*
//    * @param take another temperature object to compare to that stored within 
//    * invoking class object
//    * @return true if the comparator objects temp equal to the invoking instance temp
//    */
//   boolean sameTemp(HighTemp ht2) {
//      return hTemp == ht2.hTemp;
//   }
//   /*
//    * @param take another temperature object to compare to that stored within 
//    * invoking class object
//    * @return true if the comparator objects temp lower than the invoking 
//    * instance temp
//    */
//   boolean lowerTemp(HighTemp ht2) {
//      return hTemp>ht2.hTemp;
//   }
//}
///*
// * 
// */
//public class MethodReferenceTwice {
//   /*
//    * Generic method that takes array of any type, loops through the array and 
//    * processes each value within the array in undefined comparator function 
//    * defined according to BoolGeneric interface, against another value of whatever
//    * type is in the array
//    * @param vals: an array of any type
//    * @param inFace the defined interface method reference (lambda, method reference, 
//    * etc)
//    * @param v comparator value to pass to the inFace.func method
//    * @return the number of trues returned from the inFace.func(T[], v); 
//    */
//   static <T> int counter(T[] vals, BoolGeneric<T> inFace, T v) {
//      int count = 0;
//      for (int i = 0; i<vals.length; i++) {
//         if (inFace.func(vals[i], v)){
//            count ++;
//         }
//      }
//      return count;
//   }
//   
//   public static void maing(String [] args) {
//      int sameCount, lowerCount;
//      //create array of HighTemp objects
//      HighTemp[] weekDayHighs = {new HighTemp(29), new HighTemp(30), new 
//            HighTemp(8), new HighTemp(18), new HighTemp(29), new HighTemp(24)};
//      
//      //use counter() against HighTemp
//      sameCount = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(29));
//      System.out.println("There were " + sameCount + " days with a high of 29.");
//      
//      //see how many lower than 29
//      lowerCount = counter(weekDayHighs, HighTemp::lowerTemp, new HighTemp(29));
//      System.out.println("There were " + lowerCount + " days lower than 29.");
//      System.out.println(weekDayHighs.length-lowerCount-sameCount + " days "
//            + "were higher than 29");
//      
//      
//   }
//}
