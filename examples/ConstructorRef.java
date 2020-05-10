package examples;
/*
 * @param n take an integer
 * @return MyClass return a MyClass reference
 */
interface MyFunc{
   MyClass func(int n);
}
//keeping for reference but this class exists within package already
//class MyClass{
//   private int val;
//   MyClass(int v){
//      val = v;
//   }
//   MyClass(){
//      val = 0;
//   }
//}


public class ConstructorRef {

   public static void main(String[] args) {
      //create constructor reference
      //this refers to parameterized constructor and not the default
      MyFunc myClassCons = MyClass::new;
      
      MyClass mc = myClassCons.func(100);
      
      //even though there's a constructor overload we can't refer to this
      //as there isn't an interface in the middle to call
      //MyClass overload = myClassCons("Hello");
      
      
      //this has an error, can't use reference for this one
      //MyClass mc = myClassCons.func();
      
      //use instance created
      System.out.println("Val in mc is " + mc.getVal());

   }

}
