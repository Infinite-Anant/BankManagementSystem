
package bank.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try{
          c= DriverManager.getConnection("jdbc:mysql:///bankManagementsystem", "root" ,"Anant@2609");
           s= c.createStatement();
        
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
}
