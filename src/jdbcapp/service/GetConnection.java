package jdbcapp.service;

import java.sql.Connection;

public class GetConnection {
  private static Connection con = null;
  public static Connection getConnection(){
    try{
      Class.forName("com.mysql.jdbc.Driver");
    }
    catch(Exception e){
        e.printStackTrace();
    }
    return con;
  }
}
