import java.util.Scanner;

public class ClassParticipationDriver {

public static void main(String[] args) {
       ClassParticipation studetnList=new ClassParticipation();
       System.out.println("Enter the sutdent name now.");
       System.out.println("Type done when you are finished.");
       Scanner scnr=new Scanner(System.in);
       String name=scnr.nextLine();
       while(!name.equals("done"))
       {
           studetnList.add(name);
           name=scnr.nextLine();
       }
   System.out.println("Report on the student seen:");
   System.out.println(studetnList);
   }

}