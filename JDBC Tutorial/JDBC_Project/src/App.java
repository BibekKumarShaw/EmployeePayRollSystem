import java.sql.*;
import java.util.*;
// Insertion operation
public class App {
    /*To Perform Connection with database, we need three things
        1. url
        2. username
        3. password
    */ 
    private static final String url = "jdbc:mysql://localhost:3306/mydb";

    private static final String username = "root";
    private static final String password = "Mysql@12";
    public static void main(String[] args)
    {
        // To load Drivers
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        // To make connection with db
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            // Statement creation
            // Statement interface helps to  execute sql query using createstatement method which is present in connection instance.
            Scanner sc = new Scanner(System.in);
            Statement statement = connection.createStatement();
            while(true)
            {
                System.out.println("Enter name: ");
                String name = sc.next();
                System.out.println("Enter age: ");
                int age = sc.nextInt();
                System.out.println("Enter marks: ");
                double marks = sc.nextDouble();
                System.out.println("Want to add more data(Y/N)");
                String choice = sc.next();
                String query = String.format("INSERT INTO student(name,age,marks) VALUES('%s', '%d', '%f')",name,age ,marks);
                statement.addBatch(query);
                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }

              // when we retrieve data from the db, we use executeQuery() otherwise we use executeUpdate() method
            int arr[] = statement.executeBatch();
            // if(rowsAffected > 0){
            //     System.out.println("Data Inserted Successfully.");
            // }else{
            //     System.out.println("Data is not Inserted.");
            // }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

