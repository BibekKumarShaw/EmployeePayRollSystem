package OIB_SIP_Task1;
import java.util.HashMap;
import java.util.*;

public class OnlineReservationSystem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LoginFrom lf = new LoginFrom();

        System.out.println("....... WELCOME .......");
        System.out.println("=======Fill the login form=======");
        lf.login();
        
        System.out.println("========Fill the reservation details: =======");
        Reservation rs = new Reservation();
        rs.reserve();
    }
}
    // login():- user will have to login first by their name and password to access the reservation facilities.
class LoginFrom{
    public void login(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name(firstName_lastName):");
        String name = sc.next();

        System.out.print("Enter four digit password:");
        int password = sc.nextInt();

        System.out.println("=======Logged In Successfully.=======");
        System.out.println("================================================================================");
    }
}
   // reserve():- To reserve tickets,user will have to fill the following reservation details.To cancel their reservation,they have to remember their nam and password.
class Reservation{
    public void reserve(){

    Scanner sc = new Scanner(System.in);
    HashMap<Integer,String> mp = new HashMap<>();

    System.out.print("Enter name(firstName_lastName):");
    String name = sc.next();

    System.out.print("Enter four digit password:");
    int password = sc.nextInt();

    System.out.print("Enter Train Name(firstName_lastName):");
    String train = sc.next();

    System.out.print("Reservation date" + "(DY_MM_YY): ");
    String date = sc.next();

    System.out.print("From:");
    String from = sc.next();

    System.out.print("Destination:");
    String destination = sc.next();

    mp.put(password,name);

    System.out.println("=======Reservation has done successfully.=======");
    System.out.println("=======......Thank you...... Happy Journey.=======");
    System.out.println("NOTE- Remember your name and password for cancellation in future.");
    System.out.println("================================================================================");
    System.out.println("=======Cancel Reservation?: 1.Yes/2.No ========");
    System.out.println("=======3. Exit=======");

    int choice = sc.nextInt();

    boolean exit = false;
    while(exit != true){

    switch(choice){
        case 1:
        System.out.println("Enter name and password:");
        name = sc.next();
        password = sc.nextInt();

        if(mp.containsKey(password)){
            System.out.println("Reservation cancelled.");
        }else{
            System.out.println("Wrong name and password!");
        }
        break;

        case 2:
        System.out.println("......Thank you...... Happy Journey.");
        break;

        case 3:
        System.out.println("Thank You!");
        exit = true;
    }
}

    }

}
