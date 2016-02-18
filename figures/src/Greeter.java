/*
 * 1. Add a method sayGoodbye to the Greeter class.
 * 
 * 2. Add a method refuseHelp to the Greeter class. It should return a string such as "I am sorry, Dave. I am afraid I can't do that."
 * 
 * @author PMARINA
 * @version Feb 11, 2016
 */
public class Greeter
{
   public String sayHello()
   {
      String message = "Hello, World!";
      return message;
   }
   public String sayGoodbye()
   {
	   String message = "Bye World";
	   return message;
   }
   public String refuseHelp()
   {
	   String message = "I am sorry Dave. I am afraid I can't do that";
	   return message;
   }
}