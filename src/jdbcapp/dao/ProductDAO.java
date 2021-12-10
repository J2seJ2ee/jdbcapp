package jdbcapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import jdbcapp.impl.ProductInterface;
import jdbcapp.model.Product;
import jdbcapp.service.GetConnection;

public class ProductDAO implements ProductInterface{

    @Override
    public  int insert(Product p) {
        Connection con = null;
        int x = 0;
        try{
            con = GetConnection.getConnection();
            String sql = "insert into product(name,price,description) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setFloat(2, p.getPrice());
            ps.setString(3, p.getDescription());
            x = ps.executeUpdate();
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
        return x;
    }

    @Override
    public int delete(Product p) {
        Connection con = null;
        int x = 0;
        try{
            con = GetConnection.getConnection();
            String sql = "delete from product where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            x = ps.executeUpdate();
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
        return x;
    }

    @Override
    public int update(Product p) {
      Connection con = null;
      int x = 0;
      try{
         con = GetConnection.getConnection();
         String sql = "update product set name=?,price=?,description=? where id=?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, p.getName());
         ps.setFloat(2, p.getPrice());
         ps.setString(3, p.getDescription());
         ps.setInt(4, p.getId());
         x = ps.executeUpdate();
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
      return x;
    }
    public ArrayList<Product> getProductList(){
      Connection con = null;
        ArrayList<Product> al  = new ArrayList<>();
      try{
          con = GetConnection.getConnection();
          String sql = "select * from product";
          PreparedStatement ps = con.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          while(rs.next()){
              int id = rs.getInt(1);
              String name = rs.getString(2);
              float price = rs.getFloat(3);
              String desc =rs.getString(4);
              Product p = new Product(id, name, price, desc);
              al.add(p);
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
      return al;
    }
}
