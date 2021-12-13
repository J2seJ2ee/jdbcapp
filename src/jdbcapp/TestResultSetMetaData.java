package jdbcapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import jdbcapp.service.GetConnection;

public class TestResultSetMetaData {
    public static void main(String[] args) {
        Connection con = null;
        try{
            con = GetConnection.getConnection();
            String sql = "select id,name,price from product";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Total Column : "+rsmd.getColumnCount());
            for(int i=1; i<=3; i++){
                System.out.println(rsmd.getColumnName(i)+
                        " "+rsmd.getColumnTypeName(i)+" "+
                        rsmd.getColumnDisplaySize(i));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
              con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
}
