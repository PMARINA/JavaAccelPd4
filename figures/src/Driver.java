/*
 * 1. Add a method sayGoodbye to the Greeter class.
 * 
 * 2. Add a method refuseHelp to the Greeter class. It should return a string such as "I am sorry, Dave. I am afraid I can't do that."
 * 
 * @author PMARINA
 * @version Feb 11, 2016
 */
public class Driver
{
   public static void main(String[] args)
   {
      Greeter worldGreeter = new Greeter();
      System.out.println(worldGreeter.sayHello());
      System.out.println(worldGreeter.refuseHelp());
      System.out.println(worldGreeter.sayGoodbye());
   }
}