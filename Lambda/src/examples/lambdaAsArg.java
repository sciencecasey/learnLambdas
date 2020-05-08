package examples;

public class lambdaAsArg {
   /*
    * use a functional interface as type of first param
    * allows passing a reference to instance of the interface, usually with 
    * lambda but not necessary
    * @param sf reference to StringFunc functional interface
    * @param s string input param to use within StringFunc reference
    * @return String from the sf.func(s) method call
    */
    private static String stringOp(StringFunc sf, String s) {
       return sf.func(s);
    }
   public static void main(String[] args) {
      String inStr = "Lambdas add power to Java";
      String outStr;

      System.out.println("Here is input string: " + inStr);
      
      //use lambda in the method call to static stringOp to declare outStr
      //changes the string to uppercase
      outStr = stringOp((str)-> str.toUpperCase(), inStr);
      System.out.println("Now string is: " + outStr);
      
      
      //now remove spacing
      //call the static method and declare block operator lambda as first param
      outStr = stringOp ((str) -> {
         String result = "";
         int i;
         //remove any character not blank
         for (i = 0; i<str.length(); i++) {
            if(str.charAt(i) != ' ') {
               result += str.charAt(i);
            }
         }
         return result;
         //second method param
      }, inStr);
      
      System.out.println("The sting with spaces removed: " + outStr);
      
      //can also declare lambda ahead of time and then pass it
      
      StringFunc reverse = (str)->{
         String result = "";
         int i= str.length()-1;
         while(i>=0) {
            result += str.charAt(i);
            i--;
         }
         return result;
      };
      //call the interface reference within the stringFunc method
      System.out.println("Now the string is reversed; " 
            + stringOp(reverse, inStr));
   }

}
